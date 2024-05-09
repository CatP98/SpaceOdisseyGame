package com.cfa.game;

import com.cfa.gameObjects.Astronaut;
import com.cfa.gameObjects.BadEffect;
import com.cfa.gameObjects.GoodEffect;
import com.cfa.gameObjects.Obstacles;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    private Astronaut astronaut;
    private Game game;

    public void collision(Obstacles obstacle){
        Picture astronautPic = astronaut.getPicture();
        Picture obstaclePic = obstacle.getPicture();



    //public void collision(Obstacles obstacle){
        double astronautRight = astronaut.getPositionX() + astronaut.getWidth();
        double astronautBottom = astronaut.getPositionY() + astronaut.getHeight();
        double astronautTop = astronaut.getPositionY();

        double obstacleLeft = obstacle.getX();
        double obstacleTop = obstacle.getY();
        double obstacleBottom = obstacle.getY() + obstacle.getHeight();


        if(astronautRight >= obstacleLeft && astronautTop >= obstacleBottom && astronautBottom <= obstacleTop ) {
            if (obstacle instanceof GoodEffect) {
                ((GoodEffect) obstacle).bringHealth();
                ((GoodEffect) obstacle).incrementScore();
            } else if (obstacle instanceof BadEffect) {
                ((BadEffect) obstacle).decrementScore();
                ((BadEffect) obstacle).takeHealth();
            }
        }
    }

    public void setAstronaut(Astronaut astronaut){};

    public void setGame(Game game){};
}
