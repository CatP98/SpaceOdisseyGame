package com.cfa.game;

public enum ItemType {

    BODY1("resources/spaceship/Parts/ship6_body1.png"),
    BODY2("resources/spaceship/Parts/ship6_body2.png"),
    BODY3("resources/spaceship/Parts/ship6_body3.png"),
    CIRCLE1("resources/spaceship/Parts/ship6_circle_detail.png"),
    DETAIL1("resources/spaceship/Parts/ship6_deail1.png"),
    DETAIL2("resources/spaceship/Parts/ship6_deail2.png"),
    DETAIL3("resources/spaceship/Parts/ship6_deail3.png"),
    DETAIL4("resources/spaceship/Parts/ship6_deail4.png"),
    TURBINES("resources/spaceship/Parts/ship6_turbines.png"),
    WING1("resources/spaceship/Parts/ship6_wing_detail1.png"),
    WING2("resources/spaceship/Parts/ship6_wing_detail2.png"),
    SHIP("resources/spaceship/Ship6.png");

    private String partType;

    ItemType(String partType){
        this.partType = partType;
    }

    public String getPartType(){
        return partType;
    }
}
