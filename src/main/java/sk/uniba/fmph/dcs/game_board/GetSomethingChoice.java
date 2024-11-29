package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.Effect;
import sk.uniba.fmph.dcs.stone_age.ImmediateEffect;
import sk.uniba.fmph.dcs.stone_age.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GetSomethingChoice implements EvaluateCivilizationCardImmediateEffect{
    private final int totalNumber = 2;

    @Override
    public boolean performEffect(Player player, ImmediateEffect immediateEffect){
        if(immediateEffect.equals(ImmediateEffect.ArbitraryResource)) {
            System.out.println("Enter two resources you want to take(Food, Wood, Clay, Stone, Gold): ");
            ArrayList<Effect> effects = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            String resource;
            for (int i = 0; i < totalNumber; i++) {
                resource = scanner.next();
                switch (resource) {
                    case "Wood":
                        effects.add(Effect.WOOD);
                        break;
                    case "Food":
                        effects.add(Effect.FOOD);
                        break;
                    case "Clay":
                        effects.add(Effect.CLAY);
                        break;
                    case "Stone":
                        effects.add(Effect.STONE);
                        break;
                    case "Gold":
                        effects.add(Effect.GOLD);
                        break;
                    default:
                        System.out.println("Error! Enter your resource again: ");
                        i--;
                }
            }

            player.playerBoard().giveEffect(effects);
            return true;
        }else{
            return false;
        }
    }

}
