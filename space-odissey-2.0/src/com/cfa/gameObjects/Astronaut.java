package com.cfa.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import com.cfa.game.Background;
import com.cfa.game.Game;
import com.cfa.game.Speed;

public class Astronaut {
    private Game game;
    private Background background;
    //private Rock rock;
    //private SpaceShipItem spaceShipItem;

    private static final double x = 0;
    private double y;
    private int width, height;

    private boolean healthy = true;
    private boolean movingUp = true; //!up = down
    private boolean turbo = false; // if life is less than 3;
    private boolean leveledUp = false; // after catching 3 items, speed sets to medium

    public static final String ASTRO_PREFIX = Game.RESOURCES_PREFIX + "astro/";
    private Picture astroPicture;
    private String astroUp;
    private String astroUpTurbo;
    private String astroDown;
    private String astroDownTurbo;
    private String astroSickUp;
    private String astroSickDown;
    private String astroLifeUp;
    private String astroLifeUpTurbo;
    private String astroLifeDown;
    private String astroLifeDownTurbo;
    private String astroHappy;
    private String astroTurn;



    public Astronaut(){
        astroUp = ASTRO_PREFIX + "a-up-2.png";
        astroUpTurbo = ASTRO_PREFIX + "a-up-turbo.png";
        astroDown = ASTRO_PREFIX + "a-down-1.png";
        astroDownTurbo = ASTRO_PREFIX + "a-down-turbo.png";
        astroSickUp = ASTRO_PREFIX + "a-up-sick.png";
        astroSickDown = ASTRO_PREFIX + "a-down-2-sick.png";
        astroLifeUp = ASTRO_PREFIX + "a-up-life.png";
        astroLifeUpTurbo = ASTRO_PREFIX + "a-turbo-life.png";
        astroLifeDown = ASTRO_PREFIX + "a-down-2-life.png";
        astroLifeDownTurbo = ASTRO_PREFIX + "a-down-2-life.png";
        astroHappy = ASTRO_PREFIX + "a-celebration.png";
        astroTurn = ASTRO_PREFIX + "a-turn.png";

        y = 160;

        astroPicture = new Picture(x, y, astroHappy);
        astroPicture.load(astroHappy);
        astroPicture.draw();
        width = astroPicture.getWidth();
        height = astroPicture.getHeight();
        System.out.println("astronaut created");

    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public void setGame(Game game){
        this.game = game;
    }


    public void moveUp(){
        if(astroPicture.getY() - Game.SPEED >= -80 ){
            if(turbo){
                astroPicture.load(astroUpTurbo);
            } else if(!turbo && healthy){
                astroPicture.load(astroTurn);
                astroPicture.load(astroUp);
            } else if(!turbo && !healthy){
                astroPicture.load(astroSickUp);
            }
            astroPicture.translate(0, -Game.SPEED);
            movingUp = true;
        }
        else {
            movingUp = false;
        }

    }

    public void moveDown(){
        if(y + Game.SPEED <= 380){
            if(!turbo){
                if(healthy){
                    astroPicture.load(astroTurn);
                    astroPicture.load(astroDown);
                } else if(!healthy){
                    astroPicture.load(astroSickDown);
                }
            }
            else if(turbo){
                astroPicture.load(astroDownTurbo);
            }
            astroPicture.translate(0, Game.SPEED);
            movingUp = false;
        }
        else{
            movingUp = true;
        }
    }

    public void fire(){}


    public void changeToTurbo(){
        if(healthy){
            if(movingUp){
                astroPicture.load(astroUpTurbo);
                Game.setSpeed(Speed.FAST.getSpeedValue());
                turbo = true;
            } else if (!movingUp){
                astroPicture.load(astroDownTurbo);
                Game.setSpeed(Speed.FAST.getSpeedValue());
                turbo = true;
            }
        }
    }

    public void shieldUp(){}

    public void levelUp(){
        if(!turbo) {
            Game.setSpeed(Speed.MEDIUM.getSpeedValue());
            leveledUp = true;
        }
    }

    public void levelDown(){
        Game.setSpeed(Speed.SLOW.getSpeedValue());
        leveledUp = false;
    }

    public void changeToNormal(){
        if(turbo){
            if(movingUp){
                astroPicture.load(astroUp);
                Game.setSpeed(Speed.MEDIUM.getSpeedValue());
                turbo = false;
            } else if (!movingUp){
                astroPicture.load(astroDown);
                Game.setSpeed(Speed.MEDIUM.getSpeedValue());
                turbo = false;
            }
        }
    }

    public void turnSick(){
        if(movingUp){
            astroPicture.load(astroSickUp);
            healthy = false;
        } else if(!movingUp){
            astroPicture.load(astroSickDown);
            healthy = false;
        }
        levelDown();
    }

    public Picture getPicture() {
        return astroPicture;
    }

    public void setPicture(Picture astroPicture) {
        this.astroPicture = astroPicture;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public double getPositionX(){
       return x;
    }

    public double getPositionY(){
        return y;
    }
}
