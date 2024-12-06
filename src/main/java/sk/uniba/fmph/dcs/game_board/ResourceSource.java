package sk.uniba.fmph.dcs.game_board;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONObject;
import sk.uniba.fmph.dcs.stone_age.*;

import java.util.Map;

public final class ResourceSource implements InterfaceFigureLocationInternal {
    private String name;
    private Effect resource;
    private int maxFigures;
    private int maxFigureColors;
    private ArrayList<PlayerOrder> figures;

    public ResourceSource(String name, Effect resource, int maxFigures, int maxFigureColors) {

    }

    @Override
    public boolean placeFigures(Player player, int figureCount) {
        return false;
    }

    @Override
    public HasAction tryToPlaceFigures(Player player, int count) {
        return HasAction.NO_ACTION_POSSIBLE;
    }

    @Override
    public ActionResult makeAction(Player player, Effect[] inputResources, Effect[] outputResources) {
        return null;
    }

    @Override
    public ActionResult makeAction(Player player, Collection<Effect> inputResources, Collection<Effect> outputResources) {

        return ActionResult.ACTION_DONE_WAIT_FOR_TOOL_USE;
    }

    @Override
    public HasAction tryToMakeAction(Player player) {
        return HasAction.NO_ACTION_POSSIBLE;
    }

    @Override
    public boolean skipAction(Player player) {
        return false;
    }

    @Override
    public boolean newTurn() {
        return false;
    }




    public String state() {
        return null;
    }
}
