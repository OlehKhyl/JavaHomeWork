package com.pb.khyl.hw6;

import java.util.Objects;

public class Dog extends Animal{
    private String favoriteToy;

    public String getFavoriteToy() {
        return favoriteToy;
    }

    public void setFavoriteToy(String favoriteToy) {
        this.favoriteToy = favoriteToy;
    }

    public Dog(String food, String location) {
        super(food, location);
        super.setAnimalType("Собака");
    }

    public Dog() {
        super.setAnimalType("Собака");
    }

    @Override
    public void makeNoise() {
        System.out.println("Гав");
    }

    @Override
    public void eat() {
        System.out.println("Собака ест " + super.getFood());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return (Objects.equals(favoriteToy, dog.favoriteToy) && Objects.equals(super.getFood(), dog.getFood()) && Objects.equals(super.getLocation(), dog.getLocation()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(favoriteToy, getFood(), getLocation());
    }

    @Override
    public String toString() {
        return "Dog{" +
                "Любимая игрушка: " + favoriteToy  +
                ", Любимая еда: " + getFood() +
                ", Местонахождение: " + getLocation() +
                '}';
    }
}
