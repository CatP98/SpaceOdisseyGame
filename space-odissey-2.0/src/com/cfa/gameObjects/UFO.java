package com.cfa.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class UFO extends Obstacles implements BadEffect{

    private static Picture ufo;
    private static double x;
    private static double y;
    private int id = (int) Math.ceil(Math.random() * 4) + 1;

    public UFO() {
        super();
        /*
        x = background.getWidth();
        y = (Math.random() * background.getHeight())+ 1;
         */

        x = 1080; //background.getWidth();
        y = (Math.random() * 355.5) + 10 ;//(Math.random() * background.getHeight()) + 1;

        ufo = new Picture(x,y,"resources/o2-bottle .png");
        ufo.draw();

        System.out.println("UFO");
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
        if(ufo.getX() + ufo.getWidth() >= 0) {
            ufo.translate(-getGameSpeed(), 0);
        } else {
            ufo.delete();
        }
    }
    /*
    @Override
    public void move() {
        if(getX() + ufo.getWidth() < background.getWidth()) {
            ufo.translate(getGameSpeed(), 0);
        }
        else {
            ufo.delete();
        }
    }

     */

    @Override
    public Picture getPicture() {
        return ufo;
    }
}
