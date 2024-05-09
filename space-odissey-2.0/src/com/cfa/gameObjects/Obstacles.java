package com.cfa.gameObjects;

import com.cfa.game.Background;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import com.cfa.game.Game;

public abstract class Obstacles {


    private static Picture picture;
    public static Astronaut astronaut;
    public static Background background;
    public static Game game;


    public Obstacles(){}

    public static void setAstronaut(Astronaut astronaut) {
        Obstacles.astronaut = astronaut;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public abstract void move();

    public int getGameSpeed() {
        return game.getSpeed();
    }

    public Picture getPicture(){
        return picture;
    };
    public int getX(){
        return getPicture().getX();
    }

    public int getY(){
        return getPicture().getY();
    }

    public int getHeight(){
        return getPicture().getHeight();
    }

    public int getWidth(){
        return getPicture().getWidth();
    }

    public static void deletePic(){
        picture.delete();
    }
}