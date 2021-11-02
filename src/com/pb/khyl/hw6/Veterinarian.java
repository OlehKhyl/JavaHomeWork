package com.pb.khyl.hw6;

public class Veterinarian {
    public void treatAnimal(Animal animal) {
        System.out.println(animal.getAnimalType() + " еда: " + animal.getFood() + ", местонахождение: " + animal.getLocation());
    }
}
