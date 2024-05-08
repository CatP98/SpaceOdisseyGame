package com.cfa.game;

public enum Speed {

    FAST(20),
    MEDIUM(11),
    SLOW(5);

    private int speedValue;

    Speed(int speedValue){
        this.speedValue = speedValue;
    }

    public int getSpeedValue(){
        return speedValue;
    }

    public void setSpeed(int speedValue){
        this.speedValue = speedValue;
    }

}
