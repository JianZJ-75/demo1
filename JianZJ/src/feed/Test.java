package feed;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @Author JianZJ
 * @Date 2024/5/8 23:17
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Cat> list = new ArrayList<>();
        Collections.addAll(list, new LiHuaCat("hcc", 20), new PersianCat("zyd", 20));
        keepPet(list);
//        System.out.println(list);
    }

    public static void keepPet(ArrayList<? extends Cat> list) {
        for (Cat cat : list) {
            cat.eat();
        }
    }

//    public static void keepPet(ArrayList<? extends Dog> list) {
//        for (Dog dog : list) {
//            dog.eat();
//        }
//    }
//
//    public static void keepPet(ArrayList<? extends Animal> list) {
//        for (Animal animal : list) {
//            animal.eat();
//        }
//    }
}
