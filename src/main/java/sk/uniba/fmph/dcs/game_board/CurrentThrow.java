package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.*;

public class CurrentThrow implements InterfaceToolUse {

    private Effect throwsFor;
    private int throwResult;

    public void initiate(Player player, Effect effect, int dices) {
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


    public String state() {
        return null;
    }
}