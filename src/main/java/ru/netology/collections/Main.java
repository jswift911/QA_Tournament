package ru.netology.collections;

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player(1, "Саша", 10);
        Player player2 = new Player(2, "Паша", 5);

        Game game = new Game();
        game.register(player1);
        game.register(player2);

        System.out.println(game.getPlayers());

        //game.round("Саша", "Артём");
        int battle = game.round("Саша", "Паша");
        System.out.println(battle);
    }
}