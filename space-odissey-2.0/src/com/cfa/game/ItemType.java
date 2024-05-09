package com.cfa.game;

public enum ItemType {

    BODY1(1,"resources/spaceship/Parts/ship6_body1.png"),
    BODY2(2, "resources/spaceship/Parts/ship6_body2.png"),
    BODY3(3,"resources/spaceship/Parts/ship6_body3.png"),
    CIRCLE1(4,"resources/spaceship/Parts/ship6_circle_detail.png"),
    DETAIL1(5,"resources/spaceship/Parts/ship6_deail1.png"),
    DETAIL2(6,"resources/spaceship/Parts/ship6_deail2.png"),
    DETAIL3(7,"resources/spaceship/Parts/ship6_deail3.png"),
    DETAIL4(8,"resources/spaceship/Parts/ship6_deail4.png"),
    TURBINES(9,"resources/spaceship/Parts/ship6_turbines.png"),
    WING1(10,"resources/spaceship/Parts/ship6_wing_detail1.png"),
    WING2(11,"resources/spaceship/Parts/ship6_wing_detail2.png"),
    SHIP(12,"resources/spaceship/Ship6.png");

    private int id;
    private String partType;

    ItemType(int id, String partType){
        this.id = id;
        this.partType = partType;
    }

    public int getId(){
        return id;
    }
    public String getPartType(){
        return partType;
    }
}
