package ru.netology.collections;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class GameTest {

    Player player1 = new Player(1, "Саша", 10);
    Player player2 = new Player(2, "Паша", 5);
    Player player3 = new Player(3, "Артём", 10);

    Game game = new Game();


    // 1) Тест на регистрацию (несколько игроков)

    @Test
    public void shouldRegisterManyPlayers() {
        game.register(player1);
        game.register(player2);
        game.register(player3);

        int expected = 3;
        int actual = game.getPlayers().size();
        Assertions.assertEquals(expected, actual);
    }

    // 2) Тест на регистрацию (1 игрок)

    @Test
    public void shouldRegisterOnePlayer() {
        game.register(player1);

        int expected = 1;
        int actual = game.getPlayers().size();
        Assertions.assertEquals(expected, actual);
    }


    // 3) Тест если игрок уже зарегистрирован

    @Test
    public void shouldRegisterExistsPlayer() {
        game.register(player1);
        game.register(player1);

        int expected = 1;
        int actual = game.getPlayers().size();
        Assertions.assertEquals(expected, actual);
    }

    // 4) Тест на генерацию исключения NotRegisteredException если один игрок не зарегистрирован

    @Test
    public void shouldThrowNotRegisteredExceptionOnePlayer() {
        game.register(player1);
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Саша", "Дима");
        });
    }

    // 5) Тест на генерацию исключения NotRegisteredException если оба игрока не зарегистрированы

    @Test
    public void shouldThrowNotRegisteredExceptionBothPlayers() {
        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Вика", "Маша");
        });
    }

    // 6) Тест если первый игрок победил

    @Test
    public void shouldFirstPlayerWin() {
        game.register(player1);
        game.register(player2);

        int expected = 1;
        int actual = game.round("Саша", "Паша");
        Assertions.assertEquals(expected, actual);
    }

    // 7) Тест если второй игрок победил

    @Test
    public void shouldSecondPlayerWin() {
        game.register(player2);
        game.register(player3);

        int expected = 2;
        int actual = game.round("Паша", "Артём");
        Assertions.assertEquals(expected, actual);
    }

    // 8) Тест если ничья

    @Test
    public void shouldPlayersDraw() {
        game.register(player1);
        game.register(player3);

        int expected = 0;
        int actual = game.round("Саша", "Артём");
        Assertions.assertEquals(expected, actual);
    }

}
