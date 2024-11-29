package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.*;
import java.util.Optional;

import java.util.*;

public class CurrentThrow implements InterfaceToolUse {
    private Effect throwsFor;
    private int throwResult;
    private Throw throw_ = new Throw();
    private Player player;
    private int dices;
    private int[] dicesResults;
    private boolean toolsUsed = false;

    public void initiate(Player player, Effect effect, int dices){
        this.throwsFor = effect;
        this.player = player;
        this.dices = dices;
        int[] dicesResults = throw_.throw_(dices);
        this.dicesResults = dicesResults;
        throwResult = Arrays.stream(dicesResults).reduce(0, Integer::sum);
        boolean toolsUsed = false;
        if (canUseTools()){
            System.out.println("You can use tools to get the +1 of " + throwsFor.toString() + ". Do you want to use them? (Yes/No)");
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();
            if(answer.equals("Yes")){
                toolsUsed = useTool(throwResult % throwsFor.points());
            }
        }

        if (!toolsUsed){
            Collection<Effect> effects = new ArrayList<>();
            for (int i = 0; i < Math.floorDiv(throwResult, throwsFor.points()); i++) {
                effects.add(throwsFor);
            }
            player.playerBoard().takeResources(effects);
        }else{
            Collection<Effect> effects = new ArrayList<>();
            throwResult += throwResult % throwsFor.points();
            for (int i = 0; i < Math.floorDiv(throwResult, throwsFor.points()); i++) {
                effects.add(throwsFor);
            }
            player.playerBoard().takeResources(effects);
        }
    }

    @Override
    public boolean useTool(int idx) {
        Optional<Integer> a = player.playerBoard().useTool(idx);
        if(a.isPresent()){
            throwResult += a.get();
            toolsUsed = true;
            return true;
        }
        return false;
    }

    @Override
    public boolean canUseTools() {
        int goal = throwResult % throwsFor.points();
        if (goal == 0){
            return false;
        }
        return player.playerBoard().hasSufficientTools(goal);
    }

    @Override
    public boolean finishUsingTools() {
        return true;
    }

    public String state(){
        StringBuilder state = new StringBuilder();
        state.append("Throw result: ").append(throwResult).append("\n");
        state.append("Threw for: ").append(throwsFor.toString()).append("\n");
        state.append("Number of dices thrown: ").append(dices).append("\n");
        state.append("Dices throw results: ");
        for (int i = 0; i < dicesResults.length; i++) {
            state.append(dicesResults[i]).append(" ");
        }
        state.append("Throw result: ").append(Arrays.stream(dicesResults).reduce(0, Integer::sum)).append("\n");
        state.append("\n");
        if (toolsUsed) {
            state.append("Tools were used.\n");
            state.append("New throw result(after adding tools points): ").append(throwResult).append("\n");
            state.append(throwsFor.toString()).append(" costs ").append(throwsFor.points()).append(" resources, so player got ").append(Math.floorDiv(throwResult, throwsFor.points())).append(" of them.\n");
        }else{

            state.append(throwsFor.toString()).append(" costs ").append(throwsFor.points()).append(" resources, so player got ").append(Math.floorDiv(throwResult, throwsFor.points())).append(" of them.\n");
        }

        return state.toString();
    }
}
