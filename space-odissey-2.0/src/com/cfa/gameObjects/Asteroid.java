package com.cfa.gameObjects;

import com.cfa.game.AsteroidType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Asteroid extends Obstacles implements BadEffect {

    private static Picture asteroid;
    private static double x;
    private static double y;
    private int id = (int) Math.ceil(Math.random() * 6) + 1;


    public Asteroid() {
        super();
        /*
        x = background.getWidth() ;
        y = Math.random() * background.getHeight() ;
         */
        x = 1080; //background.getWidth();
        y = (Math.random() * 355.5) + 10 ;//(Math.random() * background.getHeight()) + 1;


        asteroid = new Picture(x,y,getAsteroidType());
        asteroid.draw();
        System.out.println("Asteroid created");
    }

    public String getAsteroidType() {
        switch (id) {
            case 1:
                return AsteroidType.ASTEROID1.getSource();
            case 2:
                return AsteroidType.ASTEROID2.getSource();
            case 3:
                return AsteroidType.ASTEROID3.getSource();
            case 4:
                return AsteroidType.ASTEROID4.getSource();
            case 5:
                return AsteroidType.ASTEROID5.getSource();
            case 6:
                return AsteroidType.ASTEROID6.getSource();
            default :
                return "resources/rock/rock3-3.png";
        }

    }
    @Override
    public int decrementScore() {
        return 0;
    }

    @Override
    public int takeHealth() {
        return 1;
    }
    @Override
    public void move() {
        if(asteroid.getX() + asteroid.getWidth() >= 0) {
            asteroid.translate(-getGameSpeed(), 0);
        } else {
            asteroid.delete();
        }
    }

    /*
    @Override
    public void move() {
        if(getX() + asteroid.getWidth() < background.getWidth()) {
            asteroid.translate(getGameSpeed(), 0);
        }
        else {
            asteroid.delete();
        }
    }

     */

    @Override
    public Picture getPicture() {
        return asteroid;
    }
}
