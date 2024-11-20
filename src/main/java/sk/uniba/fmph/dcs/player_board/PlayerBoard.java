package sk.uniba.fmph.dcs.player_board;

import java.util.*;

import sk.uniba.fmph.dcs.stone_age.InterfaceGetState;

public class PlayerBoard implements InterfaceGetState {
    private int points;
    private int houses;
//    private final playerFigures;
//    private final playerTools;
//    private final feedTribe;
    private boolean endGamePoints;


    public PlayerBoard() {

    }

    //Adding some number to users total points
    //return new amount of points
    public int addPoints(int points) {
        this.points += points;
        return this.points;
    }

    //Incrementing amount of houses user has
    public void addHouse() {
        this.houses++;
    }

    public void addEndGamePoints() {

    }

    //Showing the current state
    @Override
    public String state() {
        return "Current points: " + points + "\n" +
                "Current houses: " + houses + "\n";
    }
}