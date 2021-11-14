package com.pb.khyl.hw7;

public class Skirt extends Clothes implements WomenClothes{
    private String clothesName = "Юбка";

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public Skirt(Size size, float cost, String color) {
        super(size, cost, color);
    }

    public Skirt() {

    }


    @Override
    public void dressWomen() {
        System.out.println(clothesName + " размер: " + super.getSize() + " цвет: " + getColor() + " цена: " + getCost());
    }
}
