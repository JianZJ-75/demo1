package test;

import zj.Sun;

import java.util.Scanner;

/**
 * @Author: JianZJ
 * @Date: 2023/12/30 23:19
 */
class Person {
    String name;
    int age;
    int num;
    public Person(int... a) {
        this.age = a[0];
        this.num = a[1];
    }
    public String out() {
        return String.format(this.age + " " + this.num);
    }
}
class T extends Sun {
    public T(String name, int age, int num) {
        super(name, age, num);
    }
    public String toString() {
        return super.toString();
    }
}
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder(sc.nextLine());
        String s = sc.nextLine();
        sb.append(s);
        System.out.println(sb);
        sb = new StringBuilder(sc.nextLine());
        System.out.println(sb);
    }
}
