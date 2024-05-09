package com.cfa.game;

import com.cfa.gameObjects.Astronaut;
import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Game {

    private Astronaut astronaut;
    private CollisionDetector collisionDetector;
    private Background background;

    public static final String RESOURCES_PREFIX = "resources/";

    public static int SPEED;

    public Picture initialPic; //Include remotes explanation
    public Picture gameOverPic;
    public Picture pausePic;

    public Score score;
    public ScoreManager scoreManager;

    public Game(){
        astronaut = new Astronaut();
        SPEED = Speed.SLOW.getSpeedValue();

        System.out.println("Game Created");

    }

    public void start(Background background){
        background.moveBackground();
    }

    public void pause(){}
    public void resume(){}
    public void exitGame(){
    }
    public void removeControls(){}

    public void setKeyboard(){

    }

    public void setBackground(Background background){
        this.background = background;
    }

    public void setAstronaut(Astronaut astronaut){
        this.astronaut = astronaut;
    }

    public static void setSpeed(int speed){
        Game.SPEED = speed;
    }

    public static int getSpeed(){
        return Game.SPEED;
    }

    public void setCollisionDetector(CollisionDetector collisionDetector){
        this.collisionDetector = collisionDetector;
    }

    public void drawControls(Background background){
        this.background = background;
    }

}
