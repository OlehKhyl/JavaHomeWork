package com.pb.khyl.hw6;

import java.util.Objects;

public class Horse extends Animal{
    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Horse(String food, String location) {
        super(food, location);
        super.setAnimalType("Конь");
    }

    public Horse() {
        super.setAnimalType("Конь");
    }

    @Override
    public void makeNoise() {
        System.out.println("Иго-го");
    }

    @Override
    public void eat() {
        System.out.println("Конь ест" + super.getFood());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return (Objects.equals(breed, horse.breed) && Objects.equals(super.getFood(), horse.getFood()) && Objects.equals(super.getLocation(), horse.getLocation()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(breed, getFood(), getLocation());
    }

    @Override
    public String toString() {
        return "Horse{" +
                "Порода: " + breed +
                ", Любимая еда: " + getFood() +
                ", Местонахождение: " + getLocation() +
                '}';
    }
}
