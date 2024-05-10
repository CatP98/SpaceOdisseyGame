package com.cfa.game;

public enum ItemType {

    BODY1(1,"resources/spaceship/item1.png"),
    BODY2(2, "resources/spaceship/item2.png"),
    BODY3(3,"resources/spaceship/item3.png"),
    CIRCLE1(4,"resources/spaceship/item4.png"),
    DETAIL1(5,"resources/spaceship/item5.png"),
    DETAIL2(6,"resources/spaceship/item6.png"),
    DETAIL3(7,"resources/spaceship/item6.png"),
    DETAIL4(8,"resources/spaceship/item6.png"),
    TURBINES(9,"resources/spaceship/item6.png"),
    WING1(10,"resources/spaceship/item6.png"),
    WING2(11,"resources/spaceship/item6.png"),
    SHIP(12,"resources/spaceship/item6.png");

    private int id;
    private String partType;

    ItemType(int id, String partType){
        this.id = id;
        this.partType = partType;
    }

    public int getId(){
        return id;
    }
    public String getSource(){
        return partType;
    }
}
