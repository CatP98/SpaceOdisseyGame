package com.cfa.gameObjects;

import com.cfa.game.ItemType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SpaceShipItem extends Obstacles implements GoodEffect {

    private static Picture item;
    private static double x;
    private static double y;
    private int id = (int) Math.random() * 11 + 1;


    public SpaceShipItem() {
        super();
        x = 1080; //background.getWidth();
        y = (Math.random() * 355.5) + 10 ;//(Math.random() * background.getHeight()) + 1;

        item = new Picture(getX(),getY(),getPartType());
        item.draw();

        System.out.println("SpaceShipItem");
    }

    public String getPartType() {
        switch (id) {
            case 1:
                return ItemType.BODY1.getSource();
            case 2:
                return ItemType.BODY2.getSource();
            case 3:
                return ItemType.BODY3.getSource();
            case 4:
                return ItemType.CIRCLE1.getSource();
            case 5:
                return ItemType.DETAIL1.getSource();
            case 6:
                return ItemType.DETAIL2.getSource();
            case 7:
                return ItemType.DETAIL3.getSource();
            case 8:
                return ItemType.DETAIL4.getSource();
            case 9:
                return ItemType.TURBINES.getSource();
            case 10:
                return ItemType.WING1.getSource();
            case 11:
                return ItemType.WING2.getSource();
            default:
                return "resources/spaceship/item3.png";
        }
    }

    public Picture completeSpaceShip(){
        String completeSSString =  ItemType.SHIP.getSource();
        return new Picture(getX(),getY(),completeSSString);
    }

    @Override
    public int incrementScore() {
        return 1;
    }

    @Override
    public int bringHealth() {
        return 0;
    }

    @Override
    public void move() {
        if(item.getX() + item.getWidth() >= 0) {
            item.translate(-getGameSpeed(), 0);
        } else {
            item.delete();
        }
    }

    /*
    @Override
    public void move() {
        if(getX() + item.getWidth() < background.getWidth()) {
            item.translate(getGameSpeed(), 0);
        }
        else {
            item.delete();
        }

    }

     */

    public int getX(){
        return (int) x;
    }

    public int getY(){
        return (int) y;
    }

    @Override
    public Picture getPicture() {
        return item;
    }
}
