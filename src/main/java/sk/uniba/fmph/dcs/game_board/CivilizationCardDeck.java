package sk.uniba.fmph.dcs.game_board;

import java.util.Optional;
import java.util.Stack;

public class CivilisationCardDeck {
    private Stack<CivilizationCard> stack;
    public CivilisationCardDeck(Stack<CivilisationCard> stack){
        this.stack = stack;
    }

    public Optional<CivilisationCard> getTop(){
        if(!stack.isEmpty()){
            Optional<CivilisationCard> result = Optional.of(stack.pop());
            return result;
        }
        Optional<CivilisationCard> empty = Optional.empty();
        return empty;
    }

    public String state(){
        return "";
    }
}
