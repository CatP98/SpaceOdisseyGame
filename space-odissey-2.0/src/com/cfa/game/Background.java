package com.cfa.game;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Background {

    private Picture[] backgrounds;

    //private Picture earth;
    //private Picture planet;

    private int backgroundX;

    private final int maxX = 1080;
    private final int maxY = 380;


    public Background() {

        backgrounds = new Picture[20];
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                backgrounds[i] = new Picture(i * 1080, 0, Game.RESOURCES_PREFIX + "bck-black.png");
                backgrounds[i].draw();
            } else {
                backgrounds[i] = new Picture(i * 1080, 0, Game.RESOURCES_PREFIX + "bck-bckground-2.png");
                backgrounds[i].draw();
            }
        }
        backgroundX = 0;

        //moveBackground();

        System.out.println("Background Created");
    }

    public int getWidth() {
        return maxX;
    }

    public int getHeight() {
        return maxY;
    }

    public void moveBackground() {
        while (true) {
            try {
                Thread.sleep(100); // Adjust the speed of background movement (decreased sleep time for faster movement)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // Move the backgrounds horizontally
            backgroundX -= 8;

            // If the first background reaches the end, reset its position and move the other backgrounds accordingly
            if (maxX <= -1080) {
                backgroundX += 1080;
                Picture temp = backgrounds[0];
                backgrounds[0] = backgrounds[1];
                backgrounds[1] = backgrounds[2];
                backgrounds[2] = temp;
                backgrounds[2].translate(1280, 0); // Move the last background to the end
            }

            // Move all backgrounds
            for (Picture background : backgrounds) {
                background.translate(-Game.SPEED, 0); // Adjust the movement amount (increased movement speed)
            }
        }
    }
}
