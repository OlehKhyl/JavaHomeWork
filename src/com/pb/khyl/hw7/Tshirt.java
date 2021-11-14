package com.pb.khyl.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes{
    private String clothesName = "Футболка";

    public String getClothesName() {
        return clothesName;
    }

    public void setClothesName(String clothesName) {
        this.clothesName = clothesName;
    }

    public Tshirt(Size size, float cost, String color) {
        super(size, cost, color);
    }

    public Tshirt() {

    }

    @Override
    public void dressMan() {
        System.out.println(clothesName + " размер: " + super.getSize() + " цвет: " + getColor() + " цена: " + getCost());
    }

    @Override
    public void dressWomen() {
        System.out.println(clothesName + " размер: " + super.getSize() + " цвет: " + getColor() + " цена: " + getCost());
    }
}
