package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.HasAction;
import sk.uniba.fmph.dcs.stone_age.Effect;
import sk.uniba.fmph.dcs.stone_age.ActionResult;
import sk.uniba.fmph.dcs.stone_age.InterfaceFigureLocation;

import java.util.*;

public class FigureLocationAdaptor implements InterfaceFigureLocation {
    private final InterfaceFigureLocationInternal figureLocation;
    private final List<Player> players;

    public FigureLocationAdaptor(final InterfaceFigureLocationInternal figureLocation, List<Player> players) {
        this.figureLocation = figureLocation;
        this.players = players;
    }

    private Player findPlayerOrder(PlayerOrder player) {
        for (Player pl : players) {
            if (pl.playerOrder().equals(player)) {
                return pl;
            }
        }
        return null;
    }

    @Override
    public boolean placeFigures(PlayerOrder player, int figureCount) {
        Player p = findPlayerOrder(player);
        if (p != null) {
            return figureLocation.placeFigures(p, figureCount);
        }
        return false;
    }

    @Override
    public HasAction tryToPlaceFigures(PlayerOrder player, int count) {
        Player pl = findPlayerOrder(player);
        if (pl != null) {
            return figureLocation.tryToPlaceFigures(p, count);
        }
        return null;
    }

    @Override
    public ActionResult makeAction(PlayerOrder player, Collection<Effect> inputResources, Collection<Effect> outputResources) {
        Effect[] input = inputResources.toArray(new Effect[0]);
        Effect[] output = outputResources.toArray(new Effect[0]);
        Player pl = findPlayerOrder(player);
        if (pl != null) {
            return figureLocation.makeAction(pl, input, output);
        }
        return null;
    }

    @Override
    public boolean skipAction(PlayerOrder player) {
        Player pl = findPlayerOrder(player);
        if (pl != null) {
            return figureLocation.skipAction(pl);
        }
        return false;
    }

    @Override
    public HasAction tryToMakeAction(PlayerOrder player) {
        Player pl = findPlayerOrder(player);
        if (pl != null) {
            figureLocation.tryToMakeAction(pl);
        }
        return null;
    }

    @Override
    public boolean newTurn() {
        return figureLocation.newTurn();
    }
}