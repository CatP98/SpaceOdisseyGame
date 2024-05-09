package com.cfa.game;


import com.cfa.gameObjects.*;

import java.util.List;

public class ObstaclesFactory {

    private List<Obstacles> obstacles;
    private static int spaceShipItemsLeft = 6;

    public ObstaclesFactory() {
    }

    public void addSpaceShipItem() {
        SpaceShipItem spaceShipItem = new SpaceShipItem();
        spaceShipItemsLeft--;
        obstacles.add(spaceShipItem);
    }

    public void addAsteroid(){
        Asteroid asteroid = new Asteroid();
        obstacles.add(asteroid);
    }

    public void addUFO(){
        UFO ufo = new UFO();
        obstacles.add(ufo);
    }
    public void removeObstacle(Obstacles obstacle) {
        obstacles.remove(obstacle);
    }

    public void removeObstacles(){
        for(int i = 0; i <= (obstacles.size()-1); i++) {
            //obstacles.get(i).delete();
            obstacles.remove(i);

        }
    }


}
