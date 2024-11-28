package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.*;
import java.util.Optional;

public class CurrentThrow implements InterfaceToolUse {
    private Effect throwsFor;
    private int throwResult;
    private Player player;
    private int dices;
    private InterfacePlayerBoardGameBoard playerBoard;
    private int sumScoreOfDices;


    public CurrentThrow(Player player, Effect effect, int dices){
        this.player = player;
        throwsFor = effect;
        this.dices = dices;
        this.playerBoard = this.player.playerBoard();
        sumScoreOfDices = sumDices();
    }

    private int sumDices(){
        Throw throw_ = new Throw();
        int[] score = throw_.throw_(dices);
        int finalScore = 0;
        for (int i = 0; i < score.length; i++) {
            finalScore += score[i];
        }

        return finalScore;
    }

    public String state(){

        switch (throwsFor){
            case FOOD:

                break;
        }

        return "";
    }

    @Override
    public boolean useTool(int idx) {
        Optional<Integer> toolValue = playerBoard.useTool(idx);
        return toolValue.isPresent();
    }

    @Override
    public boolean canUseTools() {
        return false;
    }

    @Override
    public boolean finishUsingTools() {
        return false;
    }
}
