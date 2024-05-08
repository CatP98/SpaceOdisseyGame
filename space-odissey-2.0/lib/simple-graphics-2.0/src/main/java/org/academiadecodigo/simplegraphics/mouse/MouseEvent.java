//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package org.academiadecodigo.simplegraphics.mouse;

public class MouseEvent {
    private double x;
    private double y;
    private MouseEventType eventType;

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double var1) {
        this.x = var1;
    }

    public void setY(double var1) {
        this.y = var1;
    }

    public MouseEvent(double var1, double var3, MouseEventType var5) {
        this.x = var1;
        this.y = var3;
        this.eventType = var5;
    }

    public MouseEventType getEventType() {
        return this.eventType;
    }

    public String toString() {
        return "MouseEvent{x=" + this.x + ", y=" + this.y + ", eventType=" + this.eventType + '}';
    }
}
