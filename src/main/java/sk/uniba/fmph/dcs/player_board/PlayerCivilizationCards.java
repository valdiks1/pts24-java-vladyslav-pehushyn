package sk.uniba.fmph.dcs.player_board;

import java.util.HashMap;
import java.util.Map;
public class PlayerCivilizationCards {
    private final Map<EndOfGameEffect, Integer> endOfGameEffectMap = new HashMap<>();

    public void addEndOfGameEffects(EndOfGameEffect[] effects){
        for (EndOfGameEffect effect : effects) {
            if (endOfGameEffectMap.containsKey(effect)) {
                endOfGameEffectMap.put(effect, endOfGameEffectMap.get(effect) + 1);
            } else {
                endOfGameEffectMap.put(effect, 1);
            }
        }
    }

    public int calculateEndOfGameCivilizationCardPoints(int buildings, int tools, int fields, int figures){
        int sumOfEndOfGameEffects = 0;
        Map<EndOfGameEffect, Integer> greenCards = new HashMap<>();
        for(EndOfGameEffect effect: endOfGameEffectMap.keySet()){
            switch (effect){
                case Farmer -> sumOfEndOfGameEffects += fields * endOfGameEffectMap.get(effect);
                case ToolMaker -> sumOfEndOfGameEffects += tools * endOfGameEffectMap.get(effect);
                case Builder -> sumOfEndOfGameEffects += buildings * endOfGameEffectMap.get(effect);
                case Shaman -> sumOfEndOfGameEffects += figures * endOfGameEffectMap.get(effect);
                default -> greenCards.put(effect, endOfGameEffectMap.get(effect));
            }
        }

        while (true){
            int countCurrentCards = 0;
            for(EndOfGameEffect effect: greenCards.keySet()){
                int numberOfCards = greenCards.get(effect);
                if(numberOfCards > 0){
                    countCurrentCards++;
                    greenCards.put(effect, numberOfCards - 1);
                }
            }
            if(countCurrentCards == 0){
                break;
            }
            sumOfEndOfGameEffects += (int) Math.pow(2, countCurrentCards);
        }

        return sumOfEndOfGameEffects;
    }


}
