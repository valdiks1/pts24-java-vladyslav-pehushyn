package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.*;

import java.util.ArrayList;

public class ToolMakerHutFields  implements InterfaceNewTurn, InterfaceGetState {
    private PlayerOrder toolMakerFigures;
    private PlayerOrder hutFigures;
    private PlayerOrder fieldsFigures;

    private int restriction;

    private int restrictionCounter;

    public ToolMakerHutFields(int numberOfPlayers){
        if(numberOfPlayers<4){
            this.restriction = 2;
        }else{
            this.restriction = 3;
        }
    }

    public boolean placeOnToolMaker(Player player){
        if(!canPlaceOnToolMaker(player)){
            return false;
        }

        toolMakerFigures = player.playerOrder();
        restrictionCounter++;
        return player.playerBoard().takeFigures(1);
    }

    public boolean actionToolMaker(Player player){
        if(!player.playerOrder().equals(toolMakerFigures)){
            return false;
        }
        ArrayList<Effect> list = new ArrayList<>();
        list.add(Effect.TOOL);
        player.playerBoard().giveEffect(list);
        return true;
    }

    public boolean canPlaceOnToolMaker(Player player){
        return toolMakerFigures == null && player.playerBoard().hasFigures(1) && restrictionCounter<=restriction;
    }

    public boolean placeOnHut(Player player){
        if(!canPlaceOnHut(player)){
            return false;
        }

        hutFigures = player.playerOrder();
        restrictionCounter++;
        return player.playerBoard().takeFigures(2);
    }

    public boolean canPlaceOnHut(Player player){
        return hutFigures == null && player.playerBoard().hasFigures(2) && restrictionCounter<=restriction;
    }

    public boolean actionHut(Player player){
        if(!player.playerOrder().equals(hutFigures)){
            return false;
        }

        player.playerBoard().giveFigure();
        return true;
    }

    public boolean placeOnFields(Player player){
        if(!canPlaceOnFields(player)){
            return false;
        }

        fieldsFigures = player.playerOrder();
        restrictionCounter++;
        return player.playerBoard().takeFigures(1);

    }

    public boolean actionFields(Player player){
        if(!player.playerOrder().equals(fieldsFigures)){
            return false;
        }
        ArrayList<Effect> list = new ArrayList<>();
        list.add(Effect.FIELD);
        player.playerBoard().giveEffect(list);
        return true;
    }

    public boolean canPlaceOnFields(Player player){
        return fieldsFigures == null && player.playerBoard().hasFigures(1) && restrictionCounter<=restriction;
    }
    @Override
    public void newTurn(){
        toolMakerFigures = null;
        hutFigures = null;
        fieldsFigures = null;
        restrictionCounter = 0;
    }

    @Override
    public String state(){
        StringBuilder builder = new StringBuilder();
        if(toolMakerFigures != null){
            builder.append("Player number " + toolMakerFigures.getOrder() + "upgraded his tools by one point.\n");
        }
        if(hutFigures != null){
            builder.append("Player number " + hutFigures.getOrder() + "got extra figure.\n");
        }
        if(fieldsFigures != null){
            builder.append("Player number " + fieldsFigures.getOrder() + "increased his agricultural track by one point.\n");
        }
        return builder.toString();
    }


}
