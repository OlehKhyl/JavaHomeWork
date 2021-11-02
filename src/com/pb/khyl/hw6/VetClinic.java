package com.pb.khyl.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {
    public static void main(String[] args) throws Exception {
        Animal[] animal = new Animal[3];
        animal[0] = new Cat("Рыба", "Крыша");
        animal[1] = new Dog("Мясо", "Будка");
        animal[2] = new Horse("Овес", "Конюшня");

        Class vetClazz = Class.forName("com.pb.khyl.hw6.Veterinarian");
        Constructor constructor = vetClazz.getConstructor(new Class[] {});
        Object iBolit = constructor.newInstance();
        if (iBolit instanceof Veterinarian) {

            for (Animal a : animal) {
                ((Veterinarian) iBolit).treatAnimal(a);
            }
        }
    }
}
