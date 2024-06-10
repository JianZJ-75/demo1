package test.test1;

/**
 * @Author JianZJ
 * @Date 2024/6/10 22:03
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[10]);
            System.out.println("----------");
            System.out.println(2 / 0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("yuejie");
        }
        System.out.println("over");
    }
}