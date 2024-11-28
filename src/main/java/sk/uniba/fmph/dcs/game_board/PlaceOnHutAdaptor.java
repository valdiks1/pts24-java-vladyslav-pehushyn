package sk.uniba.fmph.dcs.game_board;


import sk.uniba.fmph.dcs.stone_age.ActionResult;
import sk.uniba.fmph.dcs.stone_age.Effect;
import sk.uniba.fmph.dcs.stone_age.HasAction;
import sk.uniba.fmph.dcs.stone_age.Player;

public class PlaceOnHutAdaptor implements InterfaceFigureLocationInternal{
    @Override
    public boolean placeFigures(Player player, int figureCount) {
        return false;
    }

    @Override
    public HasAction tryToPlaceFigures(Player player, int count) {
        return ActionResult.FAILURE;
    }

    @Override
    public ActionResult makeAction(Player player, Effect[] inputResources, Effect[] outputResources) {
        return ActionResult.FAILURE;
    }

    @Override
    public boolean skipAction(Player player) {
        return false;
    }

    @Override
    public HasAction tryToMakeAction(Player player) {
        return ActionResult.FAILURE;
    }

    @Override
    public boolean newTurn() {
        return false;
    }
}
