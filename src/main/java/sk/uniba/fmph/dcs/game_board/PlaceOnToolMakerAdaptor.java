package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.ActionResult;
import sk.uniba.fmph.dcs.stone_age.Effect;
import sk.uniba.fmph.dcs.stone_age.HasAction;
import sk.uniba.fmph.dcs.stone_age.Player;

public class PlaceOnToolMakerAdaptor implements InterfaceFigureLocationInternal{
    private final ToolMakerHutFields toolMaker;

    public PlaceOnToolMakerAdaptor(final ToolMakerHutFields toolMakerHutFields){
        this.toolMaker = toolMakerHutFields;
    }

    @Override
    public boolean placeFigures(Player player, int figureCount) {
        if(tryToPlaceFigures(player, figureCount).equals(HasAction.AUTOMATIC_ACTION_DONE)){
            if(toolMaker.placeOnToolMaker(player)){
                player.playerBoard().takeFigures(figureCount);
                return true;
            }
        }
        return false;
    }

    @Override
    public HasAction tryToPlaceFigures(Player player, int count) {

        if(!player.playerBoard().hasFigures(count)){
            return HasAction.NO_ACTION_POSSIBLE;
        }

        if(count != 1){
            return HasAction.NO_ACTION_POSSIBLE;
        }

        if(!toolMaker.canPlaceOnToolMaker(player)){
            return HasAction.NO_ACTION_POSSIBLE;
        }

        return HasAction.AUTOMATIC_ACTION_DONE;
    }

    @Override
    public ActionResult makeAction(Player player, Effect[] inputResources, Effect[] outputResources) {
        if(toolMaker.actionToolMaker(player)){
            return ActionResult.ACTION_DONE;
        }
        return ActionResult.FAILURE;
    }

    @Override
    public boolean skipAction(Player player) {
        return false;
    }

    @Override
    public HasAction tryToMakeAction(Player player) {
        return null;
    }

    @Override
    public boolean newTurn() {
        return false;
    }
}