package com.cfa.game;

import com.cfa.gameObjects.Astronaut;
import com.cfa.gameObjects.UFO;
import com.cfa.gameObjects.Rock;
import com.cfa.gameObjects.SpaceShipItem;


public class Main {
    public static void main(String[] args) {


        Game game = new Game();

        Background background = new Background();
        System.out.println(background.getHeight());
        System.out.println(background.getWidth());


        Astronaut astronaut = new Astronaut();
        astronaut.setBackground(background);
        System.out.println(astronaut.getHeight());
        System.out.println(astronaut.getWidth());
        System.out.println(astronaut.getPositionX());
        System.out.println(astronaut.getPositionY());

        KeyboardLogic keyboardLogic = new KeyboardLogic();
        keyboardLogic.setAstronaut(astronaut);
        keyboardLogic.setGame(game);

        //game.setBackground(background);
        game.setAstronaut(astronaut);
        astronaut.setGame(game);

        game.start(background);

    }
}