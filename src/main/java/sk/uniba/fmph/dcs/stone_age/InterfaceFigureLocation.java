package sk.uniba.fmph.dcs.stone_age;

import java.util.*;

public interface InterfaceFigureLocation {
    boolean placeFigures(PlayerOrder player, int figureCount);
    HasAction tryToPlaceFigures(PlayerOrder player, int count);
    ActionResult makeAction(PlayerOrder player, Collection<Effect> inputResources, Collection<Effect> outputResources);
    boolean skipAction(PlayerOrder player);
    HasAction tryToMakeAction(PlayerOrder player);
    boolean newTurn(); // {returns true if end of game is implied by given location}
}