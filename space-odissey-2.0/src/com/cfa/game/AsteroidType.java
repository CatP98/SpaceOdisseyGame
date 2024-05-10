package com.cfa.game;

public enum AsteroidType {
    ASTEROID1(1,"resources/rock/rock1-1.png"),
    ASTEROID2(2,"resources/rock/rock2-2.png" ),
    ASTEROID3(3,"resources/rock/rock3-3.png" ),
    ASTEROID4(4,"resources/rock/rock4-4.png" ),
    ASTEROID5(5,"resources/rock/rock5-5.png" ),
    ASTEROID6(6,"resources/rock/rock6-6.png" );

    private int id;
    private String source;

    AsteroidType(int id, String source){
        this.id = id;
        this.source = source;
    }

    public int getId(){
        return id;
    }

    public String getSource(){
        return source;
    }
}
