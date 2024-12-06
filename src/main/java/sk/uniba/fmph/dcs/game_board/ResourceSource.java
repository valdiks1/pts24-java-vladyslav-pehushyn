package sk.uniba.fmph.dcs.game_board;

import java.util.*;
import org.json.JSONObject;
import sk.uniba.fmph.dcs.stone_age.*;

public final class ResourceSource implements InterfaceFigureLocationInternal {
    private final String name;
    private final Effect resource;
    private final int maxFigures;
    private final int maxFigureColors;
    private final ArrayList<PlayerOrder> figures;
    private final CurrentThrow currentThrow;

    public ResourceSource(String name, Effect resource, int maxFigures, int maxFigureColors, CurrentThrow currentThrow) {
        if (!resource.isResourceOrFood()) {
            throw new IllegalArgumentException("Resource must be food or resource");
        }
        this.name = name;
        this.resource = resource;
        this.maxFigures = maxFigures;
        this.maxFigureColors = maxFigureColors;
        this.currentThrow = currentThrow;
        this.figures = new ArrayList<>();
    }

    @Override
    public boolean placeFigures(Player player, int figureCount) {
        if (!canPlaceFigures(player, figureCount)) {
            return false;
        }

        for (int i = 0; i < figureCount; i++) {
            figures.add(player.playerOrder());
        }
        player.playerBoard().takeFigures(figureCount);
        return true;
    }

    @Override
    public HasAction tryToPlaceFigures(Player player, int count) {
        return canPlaceFigures(player, count) ? HasAction.AUTOMATIC_ACTION_DONE : HasAction.NO_ACTION_POSSIBLE;
    }

    @Override
    public ActionResult makeAction(Player player, Effect[] inputResources, Effect[] outputResources) {
        if (!hasFiguresFromPlayer(player.playerOrder())) {
            return ActionResult.FAILURE;
        }

        if (inputResources.length > 0) {
            return ActionResult.FAILURE;
        }

        int playerFigureCount = countPlayerFigures(player.playerOrder());
        if (outputResources.length != playerFigureCount) {
            return ActionResult.FAILURE;
        }

        for (Effect output : outputResources) {
            if (!output.equals(resource)) {
                return ActionResult.FAILURE;
            }
        }

        return ActionResult.ACTION_DONE_WAIT_FOR_TOOL_USE;
    }

    @Override
    public HasAction tryToMakeAction(Player player) {
        return hasFiguresFromPlayer(player.playerOrder()) ? HasAction.WAITING_FOR_PLAYER_ACTION : HasAction.NO_ACTION_POSSIBLE;
    }

    @Override
    public boolean skipAction(Player player) {
        return false;
    }

    @Override
    public boolean newTurn() {
        figures.clear();
        return false;
    }

    public String state() {
        Map<String, Object> state = Map.of(
                "name", name,
                "resource", resource.toString(),
                "maxFigures", maxFigures,
                "maxFigureColors", maxFigureColors,
                "figures", figures.stream().map(PlayerOrder::getOrder).toList()
        );
        return new JSONObject(state).toString();
    }

    private boolean canPlaceFigures(Player player, int figureCount) {
        if (!player.playerBoard().hasFigures(figureCount)) {
            return false;
        }
        if (figures.size() + figureCount > maxFigures) {
            return false;
        }
        if (hasFiguresFromPlayer(player.playerOrder())) {
            return false;
        }
        Set<PlayerOrder> uniqueColors = new HashSet<>(figures);
        if (!figures.isEmpty() && uniqueColors.size() >= maxFigureColors) {
            return false;
        }
        return true;
    }

    private boolean hasFiguresFromPlayer(PlayerOrder playerOrder) {
        return figures.contains(playerOrder);
    }

    private int countPlayerFigures(PlayerOrder playerOrder) {
        return (int) figures.stream().filter(playerOrder::equals).count();
    }
}
