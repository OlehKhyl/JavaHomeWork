package com.pb.khyl.hw6;

import java.util.Objects;

public class Cat extends Animal{
    private int fluffiness;

    public int getFluffiness() {
        return fluffiness;
    }

    public void setFluffiness(int fluffiness) {
        this.fluffiness = fluffiness;
    }

    public Cat(String food, String location) {
        super(food, location);
        super.setAnimalType("Кот");
    }

    public Cat() {
        super.setAnimalType("Кот");
    }

    @Override
    public void makeNoise() {
        System.out.println("Мяу");
    }

    @Override
    public void eat() {
        System.out.println(super.getAnimalType() + " ест " + super.getFood());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return (Objects.equals(fluffiness, cat.fluffiness) && Objects.equals(super.getFood(), cat.getFood()) && Objects.equals(super.getLocation(), cat.getLocation()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(fluffiness, getFood(), getLocation());
    }

    @Override
    public String toString() {
        return "Cat{" +
                "Пушистость: " + fluffiness +
                ", Любимая еда: " + getFood() +
                ", Местонахождение: " + getLocation() +
                '}';
    }
}
