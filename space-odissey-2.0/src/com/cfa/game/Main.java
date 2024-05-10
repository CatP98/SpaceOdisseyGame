package com.cfa.game;

import com.cfa.gameObjects.Astronaut;
import com.cfa.gameObjects.Obstacles;


public class Main {
    public static void main(String[] args) {

        // 1st - Instances:
        Game game = new Game();
        Background background = new Background();
        Astronaut astronaut = new Astronaut();
        KeyboardLogic keyboardLogic = new KeyboardLogic();
        CollisionDetector collisionDetector = new CollisionDetector();

        // 2nd - Dependencies:
        game.setAstronaut(astronaut);
        game.setCollisionDetector(collisionDetector);

        astronaut.setBackground(background);

        keyboardLogic.setAstronaut(astronaut);
        keyboardLogic.setGame(game);

        collisionDetector.setGame(game);
        collisionDetector.setAstronaut(astronaut);

        Obstacles.setAstronaut(astronaut);


        // Start the game:
        game.start(background);

    }
}