package com.pb.khyl.hw7;

public abstract class Clothes {
    private Size size;
    private float cost;
    private String color;

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Clothes(Size size, float cost, String color) {
        this.size = size;
        this.cost = cost;
        this.color = color;
    }

    public Clothes() {

    }
}
