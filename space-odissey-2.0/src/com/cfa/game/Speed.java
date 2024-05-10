package com.cfa.game;

public enum Speed {

    FAST(35),
    MEDIUM(20),
    SLOW(15);

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
