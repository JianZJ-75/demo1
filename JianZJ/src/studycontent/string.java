package studycontent;

import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.regex.Pattern;

public class string {
    public static Pattern pattern = Pattern.compile(" ");
    public static void main(string[] args) {
        String s1 = "zjyyds!";
        // 先在常量池找，然后在堆
        String s2 = s1.intern();
        // 将字符串转换为编码数组输出
        System.out.println(Arrays.toString(s1.getBytes(StandardCharsets.UTF_8)));
        // 去除字符串开头与结尾的空格
        String s3 = s1.trim();
        // 将字符串按照某个字符分割（空位是\\s+） 2为拆分个数，可加可不加
        String[] s4 = s1.split("\\s+", 2);
        String[] s5 = pattern.split(s1);
        // 比较字符串
        /**
         * 比较字符串
         * ok1 返回int
         * ok2 返回boolean但是需要在使用前判断s1不为空
         * ko3 返回boolean不需要判断非空                 最优
         * ok4 返回boolean可以将字符串与任何的字符序列（StringBuffer、StringBuilder、String、CharSequence）进行比较
         */
        int ok1 = s1.compareTo(s2);
        boolean ok2 = s1.equals(s2);
        boolean ok3 = Objects.equals(s1, s2);
        boolean ok4 = s1.contentEquals(s2);
        /**
         * 查找
         * index1 查找第一个
         * index2 从指定位置开始查找第一个
         */
        int index1 = s1.indexOf("z");
        int index2 = s1.indexOf("j", 1);
        /**
         * 截取
         * s5 2取5不取
         * s6 2之后全部
         */
        String s6 = s1.substring(2, 6);
        String s7 = s1.substring(2);
        /**
         * 拼接
         * s7 与append相比，concat()方法在遇到字符串为 null 的时候，会抛出 NullPointerException，而“+”号操作符会把 null 当做是“null”字符串来处理。”
         *    如果拼接的字符串是一个空字符串（""），那么 concat 的效率要更高一点,毕竟不需要 new StringBuilder 对象。
         * s8 用第一个来分割并拼接
         * s10 用最后一个来分割拼接
         * s11 StringUtils在jdk11后被移除
         */
        String s8 = s1.concat(s2);
        String s9 = String.join("-", s1, s2);
        List<String> s10 = new ArrayList<>();
        s10.add("123");
        s10.add("456");
        s10.add("789");
//        String s11 = StringUtils.join(s10, "-");
        // 数字转字符串
        String s12 = String.valueOf(123);
    }
}
