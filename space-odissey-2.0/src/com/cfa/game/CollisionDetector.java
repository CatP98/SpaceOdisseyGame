package com.cfa.game;

import com.cfa.gameObjects.Astronaut;
import com.cfa.gameObjects.BadEffect;
import com.cfa.gameObjects.GoodEffect;
import com.cfa.gameObjects.Obstacles;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class CollisionDetector {

    private Astronaut astronaut;
    private Game game;

    public void collision(Obstacles obstacle, Astronaut astronaut){
        Picture astronautPic = astronaut.getPicture();
        Picture obstaclePic = obstacle.getPicture();
/*
        double astronautRight = astronautPic.getX() + astronautPic.getWidth();
        double astronautBottom = astronautPic.getY() + astronautPic.getHeight();
        double astronautTop = astronautPic.getY();

        double obstacleLeft = obstaclePic.getX();
        double obstacleTop = obstaclePic.getY();
        double obstacleBottom = obstaclePic.getY() + obstaclePic.getHeight();


 */

        double astronautRight = astronaut.getPositionX() + astronaut.getWidth();
        double astronautBottom = astronaut.getPositionY() + astronaut.getHeight();
        double astronautTop = astronaut.getPositionY();

        double obstacleLeft = obstacle.getX();
        double obstacleTop = obstacle.getY();
        double obstacleBottom = obstacle.getY() + obstacle.getHeight();



        if(astronautRight >= obstacleLeft && astronautTop >= obstacleBottom && astronautBottom <= obstacleTop ) {
            if (obstacle instanceof GoodEffect) {
                System.out.println("obstacle COLLISION");
                ((GoodEffect) obstacle).bringHealth();
                ((GoodEffect) obstacle).incrementScore();
            } else if (obstacle instanceof BadEffect) {
                ((BadEffect) obstacle).decrementScore();
                ((BadEffect) obstacle).takeHealth();
            }
        }
        obstaclePic.delete();
    }

    public void setAstronaut(Astronaut astronaut){ this.astronaut = astronaut;};

    public void setGame(Game game){ this.game = game;};
}
