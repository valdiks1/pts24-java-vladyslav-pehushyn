package sk.uniba.fmph.dcs.game_board;

import org.json.JSONObject;
import sk.uniba.fmph.dcs.stone_age.InterfaceGetState;
import sk.uniba.fmph.dcs.stone_age.Location;
import sk.uniba.fmph.dcs.stone_age.Player;


import java.util.*;

public class GameBoard implements InterfaceGetState {
    private final Map<Location, InterfaceFigureLocationInternal> locs;
    private static final int CLAY_IN_CLAY_MOUND = 18;
    private static final int STONE_IN_QUARRY = 12;
    private static final int GOLD_IN_RIVER = 10;
    private static final int WOOD_IN_FOREST = 28;

    private static final int BUILDING_PILES = 4;

    /**
     * @return state combined from everything on the game board
     */
    @Override
    public String state() {
        Map<Location, String> everyState = new HashMap<>();

        for (var x : locs.keySet()) {
            everyState.put(x, locs.get(x).state());
        }

        var res = new JSONObject(everyState);
        return res.toString();
    }
}