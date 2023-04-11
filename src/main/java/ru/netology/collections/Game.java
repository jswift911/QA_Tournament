package ru.netology.collections;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Player> players = new HashMap<>();

    public Map<String, Player> getPlayers() {
        return players;
    }

    public void register(Player player) {
        if (!players.containsKey(player.getName())) {
            players.put(player.getName(), player);
        }
    }

    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = players.get(playerName1);
        Player player2 = players.get(playerName2);

        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Один или оба игроков не зарегистрированы");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}