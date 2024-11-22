package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.Effect;
import sk.uniba.fmph.dcs.stone_age.InterfacePlayerBoardGameBoard;
import sk.uniba.fmph.dcs.stone_age.InterfaceToolUse;
import sk.uniba.fmph.dcs.stone_age.Player;

public class CurrentThrow implements InterfaceToolUse {
    private Effect throwsFor;
    private int throwResult;
    private Player player;
    private int dices;
    private InterfacePlayerBoardGameBoard playerBoard;


    public CurrentThrow(Player player, Effect effect, int dices){
        this.player = player;
        throwsFor = effect;
        this.dices = dices;
    }

    public String state(){
        return "";
    }

    @Override
    public boolean useTool(int idx) {
        return false;
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
