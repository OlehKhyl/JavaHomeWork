package com.pb.khyl.hw7;

public class Tie extends Clothes implements ManClothes{
    private String clothesName = "Галстук";

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public Tie(Size size, float cost, String color) {
        super(size, cost, color);
    }

    public Tie() {

    }

    @Override
    public void dressMan() {
        System.out.println(clothesName + " размер: " + super.getSize() + " цвет: " + getColor() + " цена: " + getCost());
    }
}
