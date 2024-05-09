package com.cfa.gameObjects;

import org.academiadecodigo.simplegraphics.pictures.Picture;


public class Oxigen extends Obstacles implements GoodEffect{

    private static Picture oxigen;
    private static double x;
    private static double y;

    public Oxigen() {
        super();
        x = background.getWidth() + oxigen.getWidth();
        y = Math.random() * background.getHeight() + oxigen.getHeight();
        oxigen = new Picture(x,y,"resources/o2 .png");
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
        if(x + oxigen.getWidth() < background.getWidth()) {
            oxigen.translate(getGameSpeed(), 0);
        }
        else {
            oxigen.delete();
        }

    }
}
