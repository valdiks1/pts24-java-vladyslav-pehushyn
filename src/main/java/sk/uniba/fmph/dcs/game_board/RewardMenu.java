package sk.uniba.fmph.dcs.game_board;

import org.json.JSONObject;
import sk.uniba.fmph.dcs.stone_age.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RewardMenu implements InterfaceTakeReward {
    private ArrayList<Effect> rewards;
    private Player[] players;
    private ArrayList<PlayerOrder> remainingPlayers;


    public RewardMenu(Player[] players){
        this.players = players;
        this.remainingPlayers = new ArrayList<>();
        for (int i = 0; i < players.length; i++){
            remainingPlayers.add(players[i].playerOrder());
        }
    }
    public void initiate(Effect[] menu){
        this.rewards.addAll(List.of(menu));
    }

    @Override
    public boolean takeReward(PlayerOrder player, Effect reward) {
        if(!rewards.contains(reward)){
            return false;
        }
        if (!remainingPlayers.contains(player)){
            return false;
        }
        for (Player p : players){
            if (p.playerOrder().equals(player)){
                remainingPlayers.remove(player);
                rewards.remove(reward);
                p.playerBoard().giveEffect(List.of(reward));
                return true;
            }
        }
        return false;
    }

    @Override
    public HasAction tryMakeAction(PlayerOrder player) {
        if (rewards.isEmpty()){
            return HasAction.NO_ACTION_POSSIBLE;
        }
        if (!remainingPlayers.contains(player)){
            return HasAction.NO_ACTION_POSSIBLE;
        }
        if (rewards.size() == 1){
            for (Player p : players){
                if (p.playerOrder().equals(player)){
                    p.playerBoard().giveEffect(rewards);
                    remainingPlayers.remove(player);
                    return HasAction.AUTOMATIC_ACTION_DONE;
                }
            }
        }
        return HasAction.WAITING_FOR_PLAYER_ACTION;
    }
    public String State(){
        Map<String, Object> state = Map.of(
                "rewards", rewards,
                "players", players,
                "remainingPlayers", remainingPlayers
        );
        return new JSONObject(state).toString();
    }
}
