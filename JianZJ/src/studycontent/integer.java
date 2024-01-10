package studycontent;

public class integer {
    public static void main(String[] args) {
        // 缓存池-128-127
        Integer i1 = Integer.valueOf(1);
        // 字符串转int
        String s = "12412";
        int i2 = Integer.parseInt(s);
        // 输出二进制
        System.out.println(Integer.toBinaryString(i2));
    }
}
