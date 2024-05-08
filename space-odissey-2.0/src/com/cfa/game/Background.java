package com.cfa.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture background;
    private int width, height;
    private Picture earth;
    private Picture planet;


    public Background(){
        background = new Picture(0,0,Game.RESOURCES_PREFIX + "bckground3.png");
        background.draw();
        width = background.getWidth();
        height = background.getHeight();

        moveBackground();
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public Picture getBackground(){
        return background;
    }

    public void moveBackground(){
        background.translate(Game.SPEED, 0);
    }

}
