package com.pb.khyl.hw7;

import static com.pb.khyl.hw7.Size.*;

public class Atelier {
    public static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда: ");
        for (Clothes c : clothes) {
            if (c instanceof ManClothes) {
                ((ManClothes) c).dressMan();
            }
        }
        System.out.println();
    }

    public static void dressWoman(Clothes[] clothes) {
        System.out.println("Женская одежда: ");
        for (Clothes c : clothes) {
            if (c instanceof WomenClothes) {
                ((WomenClothes) c).dressWomen();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
       Clothes clothes0 = new Tshirt(S, 120.45f, "Синий");
       Clothes clothes1 = new Pants(M, 532.99f, "Черный");
       Clothes clothes2 = new Skirt(XS, 324.00f, "Зеленый");
       Clothes clothes3 = new Tie(L, 287.25f,"Красный");

        Clothes[] clothes = new Clothes[]{clothes0, clothes1, clothes2, clothes3};

        dressMan(clothes);

        dressWoman(clothes);

    }
}
