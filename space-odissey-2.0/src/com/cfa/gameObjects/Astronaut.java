package com.cfa.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;
import com.cfa.game.Background;
import com.cfa.game.Game;
import com.cfa.game.Speed;

public class Astronaut {
    private Game game;
    private Background background;
    private Rock rock;
    private SpaceShipItem spaceShipItem;

    private static final double x = 8;
    private double y;

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



    public Astronaut(){
        astroUp = ASTRO_PREFIX + "up.png";
        astroUpTurbo = ASTRO_PREFIX + "up-turbo.png";
        astroDown = ASTRO_PREFIX + "down.png";
        astroDownTurbo = ASTRO_PREFIX + "down-turbo.png";
        astroSickUp = ASTRO_PREFIX + "up-dangerous.png";
        astroSickDown = ASTRO_PREFIX + "down-dangerous.png";
        astroLifeUp = ASTRO_PREFIX + "up-life.png";
        astroLifeUpTurbo = ASTRO_PREFIX + "up-turbo-life.png";
        astroLifeDown = ASTRO_PREFIX + "down-life.png";
        astroLifeDownTurbo = ASTRO_PREFIX + "down-tubo-life.png";

        y = 530;

        astroPicture = new Picture(x, y, astroUp);
        astroPicture.load(astroUp);
        astroPicture.draw();

    }

    public void setBackground(Background background) {
        this.background = background;
    }

    public void setGame(Game game){
        this.game = game;
    }


    public void moveUp(){
        if(y - Game.SPEED <= astroPicture.getHeight()){
            y = y -Game.SPEED;
            astroPicture.translate(0, Game.SPEED);
        }
        System.out.println("Astronaut moved up");
    }

    public void moveDown(){
        if(y + Game.SPEED <= (background.getHeight() - astroPicture.getHeight())){
            y = y + Game.SPEED;
            astroPicture.translate(0, Game.SPEED);
        }
        System.out.println("Astronaut moved down");
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

    public void levelUp(){
        if(!turbo) {
            Game.setSpeed(Speed.MEDIUM.getSpeedValue());
            leveledUp = true;
        }
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
    }

    public Picture getAstroPicture() {
        return astroPicture;
    }

    public void setAstroPicture(Picture astroPicture) {
        this.astroPicture = astroPicture;
    }

}
