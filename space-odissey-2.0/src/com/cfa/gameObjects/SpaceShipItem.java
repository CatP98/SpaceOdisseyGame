package com.cfa.gameObjects;

import com.cfa.game.ItemType;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SpaceShipItem extends Obstacles implements GoodEffect {

    private static Picture item;
    private static double x;
    private static double y;
    private int id = (int) Math.ceil(Math.random() * 12) + 1;


    public SpaceShipItem() {
        super();
        x = background.getWidth() + 120;
        y = Math.random() * background.getHeight() + 120;

        item = new Picture(x,y,getPartType());
    }

    public String getPartType() {
        switch (id) {
            case 1:
                return ItemType.BODY1.getPartType();
            case 2:
                return ItemType.BODY2.getPartType();
            case 3:
                return ItemType.BODY3.getPartType();
            case 4:
                return ItemType.CIRCLE1.getPartType();
            case 5:
                return ItemType.DETAIL1.getPartType();
            case 6:
                return ItemType.DETAIL2.getPartType();
            case 7:
                return ItemType.DETAIL3.getPartType();
            case 8:
                return ItemType.DETAIL4.getPartType();
            case 9:
                return ItemType.TURBINES.getPartType();
            case 10:
                return ItemType.WING1.getPartType();
            case 11:
                return ItemType.WING2.getPartType();
            case 12:
                return ItemType.SHIP.getPartType();
            default:
                return "";
        }
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
        if(x + item.getWidth() < background.getWidth()) {
            item.translate(getGameSpeed(), 0);
        }
        else {
            item.delete();
        }

    }
}
