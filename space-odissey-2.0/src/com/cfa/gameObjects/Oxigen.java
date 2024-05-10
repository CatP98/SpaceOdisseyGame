package com.cfa.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Oxigen extends Obstacles implements GoodEffect{

    private /*static */ Picture oxigen;
    private static double x;
    private static double y;

    public Oxigen() {
        super();
        /*
        x = background.getWidth() ;
        y = (Math.random() * background.getHeight()) + 1;

         */
        x = 1080; //background.getWidth();
        y = (Math.random() * 355.5) + 10 ;//(Math.random() * background.getHeight()) + 1;

        oxigen = new Picture(x,y,"resources/o2 .png");
        oxigen.draw();
        System.out.println("oxigen created");
    }
    @Override
    public int incrementScore() {
        return 0;
    }

    @Override
    public int bringHealth() {
        return 1;
    }

    @Override
    public void move() {
        if(oxigen.getX() + oxigen.getWidth() >= 0) {
            oxigen.translate(-getGameSpeed(), 0);
        } else {
            oxigen.delete();
        }
    }


    @Override
    public Picture getPicture() {
        return oxigen;
    }
}
