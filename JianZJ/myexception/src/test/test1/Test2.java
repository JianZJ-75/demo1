package test.test1;

/**
 * @Author JianZJ
 * @Date 2024/6/11 20:34
 */
public class Test2 {
    public static void main(String[] args) throws NullPointerException, ArrayIndexOutOfBoundsException {
//        int[] arr = {1, 2, 3, 4, 5};
        int[] arr = null;
        int max = 0;
        try {
            max = getMax(arr);
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("索引越界异常");
        }
        System.out.println(max);
    }

    public static int getMax(int[] arr) {
        if (arr == null) {
            // 手动创建一个异常对象, 并把这个异常交给方法的调用者处理
            // 此时方法就会结束, 下面的代码不会再执行了
            throw new NullPointerException();
        }
        if (arr.length == 0) {
            throw new ArithmeticException();
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}