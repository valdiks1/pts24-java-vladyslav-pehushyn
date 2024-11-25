package sk.uniba.fmph.dcs.player_board;

import sk.uniba.fmph.dcs.stone_age.InterfaceGetState;

public class PlayerFigures implements InterfaceGetState {
private int totalFigures;
private int figures;

    public void addNewFigure(){
        if(totalFigures < 10){
            totalFigures++;
        }
    }

    public boolean hasFigures(int count){
        return figures >= count;
    }

    public int getTotalFigures() {
        return totalFigures;
    }

    public boolean takeFigures(int count){
        if(hasFigures(count)){
            figures = figures - count;
            return true;
        }else{
            return  false;
        }
    }

    public void newTurn (){
        figures = totalFigures;
    }

    @Override
    public String state(){
        if(figures > 0){
            return "Player still have " + figures + " to place";
        }else{
            return "Player doesn't have any figure to place on the board";
        }
    }

}
