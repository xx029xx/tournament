package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void VictoryOnePlayerTest() {
        Game game = new Game();
        Player player1 = new Player(1, "Login", 500);
        Player player2 = new Player(2, "Play", 400);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Login", "Play");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void VictoryTwoPlayerTest() {
        Game game = new Game();
        Player player1 = new Player(1, "Login", 300);
        Player player2 = new Player(2, "Play", 600);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Login", "Play");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void DrawTest() {
        Game game = new Game();
        Player player1 = new Player(1, "Login", 100);
        Player player2 = new Player(2, "Play", 100);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Login", "Play");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void NotRegisteredPlayer2Test() {
        Game game = new Game();
        Player player1 = new Player(1, "Login", 90);
        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Login", "Play");
        });
    }

    @Test
    public void NotRegisteredPlayer1Test() {
        Game game = new Game();
        Player player2 = new Player(2, "Play", 90);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Login", "Play");
        });
    }

    @Test
    public void NotRegisteredPlayersTest() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Login", "Play");
        });
    }
}
