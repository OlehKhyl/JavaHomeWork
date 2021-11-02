package com.pb.khyl.hw6;

public class Animal {
    private String animalType;
    private String food;
    private String location;

    public Animal(String food, String location) {
        this.food = food;
        this.location = location;
    }

    public Animal() {

    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void makeNoise() {
        System.out.println(animalType + " издает звуки");
    }

    public void eat() {
        System.out.println(animalType + " ест");
    }

    public void sleep() {
        System.out.println(animalType + " спит");
    }
}
