package com.cfa.game;

import com.cfa.gameObjects.Astronaut;
import com.cfa.gameObjects.UFO;
import com.cfa.gameObjects.Rock;
import com.cfa.gameObjects.SpaceShipItem;


public class Main {
    public static void main(String[] args) {

        Game game = new Game();

        Astronaut astronaut = new Astronaut();

        KeyboardLogic keyboardLogic = new KeyboardLogic();
        keyboardLogic.setGame(game);
        keyboardLogic.setAstronaut(astronaut);

        Background background = new Background();
        astronaut.setBackground(background);
        astronaut.setGame(game);



        game.setBackground(background);
        game.setAstronaut(astronaut);

        game.start();

    }
}