package test.test2;

import java.util.Scanner;

/**
 * @Author JianZJ
 * @Date 2024/6/11 20:41
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GirlFriend girlFriend = new GirlFriend();
        while (true) {
            try {
                System.out.println("请输入你心仪的女朋友的名字:");
                String name = sc.nextLine();
                girlFriend.setName(name);
                System.out.println("请输入你心仪的女朋友的年龄:");
                String age = sc.nextLine();
                girlFriend.setAge(Integer.parseInt(age));
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            } catch (NameFormatException e) {
                e.printStackTrace();
            } catch (AgeOutOfBoundsException e) {
                e.printStackTrace();
            }
        }
        System.out.println(girlFriend);
    }
}