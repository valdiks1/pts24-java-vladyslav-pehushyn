package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CurrentThrow implements InterfaceToolUse {

    private Effect throwsFor;
    private int throwResult;
    private Player player;
    private boolean toolsUsed;
    private boolean isFinished;

    public void initiate(Player player, Effect effect, int dices) {
        this.throwsFor = effect;
        this.player = player;
        int[] dicesScoreArray = Throw.throw_(dices);
        throwResult = sumArray(dicesScoreArray);
    }

    private int sumArray(int[] array){
        int result = 0;
        for(int dice : array){
            result += dice;
        }
        return result;
    }

    @Override
    public boolean useTool(int idx) {
        Optional<Integer> tool = player.playerBoard().useTool(idx);
        if (tool.isPresent()) {
            throwResult += tool.get();
            toolsUsed = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean canUseTools() {
        return this.player.playerBoard().hasSufficientTools(1);
    }

    @Override
    public boolean finishUsingTools() {
        if (isFinished) {
            return false;
        }
        List<Effect> effects = new ArrayList<>();

        switch (throwsFor) {
            case WOOD:
                for (int i = 0; i < throwResult / Effect.WOOD.points(); i++) {
                    effects.add(Effect.WOOD);
                }
                break;
            case CLAY:
                for (int i = 0; i < throwResult / Effect.CLAY.points(); i++) {
                    effects.add(Effect.CLAY);
                }
                break;
            case STONE:
                for (int i = 0; i < throwResult / Effect.STONE.points(); i++) {
                    effects.add(Effect.STONE);
                }
                break;
            case GOLD:
                for (int i = 0; i < throwResult / Effect.GOLD.points(); i++) {
                    effects.add(Effect.GOLD);
                }
                break;
            case FOOD:
                for (int i = 0; i < throwResult / Effect.FOOD.points(); i++) {
                    effects.add(Effect.FOOD);
                }
                break;
            default:
                break;
        }

        player.playerBoard().giveEffect(effects);
        isFinished = true;
        return true;
    }


    public String state() {
        return null;
    }
}