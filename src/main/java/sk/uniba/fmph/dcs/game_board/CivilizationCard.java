package sk.uniba.fmph.dcs.game_board;

import sk.uniba.fmph.dcs.stone_age.EndOfGameEffect;
import sk.uniba.fmph.dcs.stone_age.ImmediateEffect;

import java.util.Collections;
import java.util.List;

public class CivilizationCard {
    List<ImmediateEffect> immediateEffectType;
    List<EndOfGameEffect> EndOfGameEffectType;

    public CivilizationCard(List<ImmediateEffect> immediateEffectType, List<EndOfGameEffect> EndOfGameEffectType){
        this.immediateEffectType = immediateEffectType;
        this.EndOfGameEffectType = EndOfGameEffectType;
    }

    public List<EndOfGameEffect> getEndOfGameEffectType() {
        return Collections.unmodifiableList(EndOfGameEffectType);
    }

    public List<ImmediateEffect> getImmediateEffectType() {
        return Collections.unmodifiableList(immediateEffectType);
    }
}
