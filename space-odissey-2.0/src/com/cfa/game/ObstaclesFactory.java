package com.cfa.game;


import com.cfa.gameObjects.*;

import java.util.List;
import java.util.ArrayList;

public class ObstaclesFactory {

    private List<Obstacles> obstacles;
    private static int spaceShipItemsLeft = 6;

    public ObstaclesFactory() {
        obstacles = new ArrayList<>();
    }


    public void addSpaceShipItem() {
        if(existMoreSpaceShipItems()){
            SpaceShipItem spaceShipItem = new SpaceShipItem();
            spaceShipItemsLeft--;
            obstacles.add(spaceShipItem);
        }
    }

    public boolean existMoreSpaceShipItems(){
        while(spaceShipItemsLeft > 0) {
            return true;
        }
        return false;
    }

    public void addAsteroid(){
        Asteroid asteroid = new Asteroid();
        obstacles.add(asteroid);
    }

    public void addUFO(){
        UFO ufo = new UFO();
        obstacles.add(ufo);
    }

    public void addO2(){
        Oxigen oxigen = new Oxigen();
        obstacles.add(oxigen);
    }

    public void removeObstacle(int i) {
        obstacles.remove(i);
    }

    public void removeObstacles(){
        for(int i = 0; i <= (obstacles.size()-1); i++) {
            //obstacles.get(i).delete();
            obstacles.remove(i);

        }
    }

    public int getSize(){
        return obstacles.size();
    }

    public Obstacles getObstacle(int index){
        return obstacles.get(index);
    }
}
