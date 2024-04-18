package iotest.test1;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author JianZJ
 * @Date 2024/4/17 21:14
 */
public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
        * 制造假数据:
        *   需求: 制造假数据也是开发中的一个能力, 在各个网上爬取数据, 是其中一个方法
        *       获取姓氏: https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&amp;from=kg0
        *       获取男生名字: http://www.haoming8.cn/baobao/10881.html
        *       获取女生名字: http://www.haoming8.cn/baobao/7641.html
        * */

        // 1. 定义变量记录网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&amp;from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        // 2. 爬取数据, 把网址上的所有数据拼接成一个字符串
        String familyNameStr = webCrawler(familyNameNet);
        String boyNameStr = webCrawler(boyNameNet);
        String girlNameStr = webCrawler(girlNameNet);

        // 3. 通过正则表达式, 把其中符合要求的数据获取出来
        List<String> familyNameTempList = getData(familyNameStr, "([\\u4E00-\\u9FA5]{4})(，|。)", 1);
        List<String> boyNameTempList = getData(boyNameStr, "([\\u4E00-\\u9FA5]{2})(、|。)", 1);
        List<String> girlNameTempList = getData(girlNameStr, "(.. ){4}..", 0);

        // 4. 处理数据
        // familyNameTempList(姓氏)
        // 处理方案: 把每一个姓氏拆开并添加到一个新的集合当中
        List<String> familyNameList = new ArrayList<>();
        for (String s : familyNameTempList) {
            for (int i = 0; i < s.length(); i++) {
                familyNameList.add(s.charAt(i) + "");
            }
        }

        // boyNameTempList(男生的名字)
        // 处理方案: 去除其中重复元素
        List<String> boyNameList = new ArrayList<>();
        for (String s : boyNameTempList) {
            if (!boyNameList.contains(s)) {
                boyNameList.add(s);
            }
        }

        // girlNameTempList(女生名字)
        // 处理方案: 把里面的每一个元素用空格切割, 得到每一个女生的名字
        List<String> girlNameList = new ArrayList<>();
        for (String s : girlNameTempList) {
            String[] strings = s.split(" ");
            for (String string : strings) {
                girlNameList.add(string);
            }
        }

        // 5. 生成数据
        // 姓名(唯一) - 性别 - 年龄
        List<String> list = getInfos(familyNameList, boyNameList, girlNameList, 70, 50);
        Collections.shuffle(list);
        System.out.println(list);

    }

    /*
    * 作用:
    *       获取男生和女生的信息: 张三-男-23
    * 形参:
    *       参数一: 装着姓氏的集合
    *       参数二: 装着男生名字的集合
    *       参数三: 装着女生名字的集合
    *       参数四: 男生的个数
    *       参数五: 女生的个数
    * */
    private static List<String> getInfos(List<String> familyNameList, List<String> boyNameList, List<String> girlNameList, int boyCount, int girlCount) {
        // 1. 生成男生不重复的名字
        Set<String> boyName = new HashSet<>();
        while (boyName.size() != boyCount) {
            // 随机
            Collections.shuffle(familyNameList);
            Collections.shuffle(boyNameList);
            boyName.add(familyNameList.get(0) + boyNameList.get(0));
        }
        // 2. 生成女生不重复的明细
        Set<String> girlName = new HashSet<>();
        while (girlName.size() != girlCount) {
            // 随机
            Collections.shuffle(familyNameList);
            Collections.shuffle(girlNameList);
            girlName.add(familyNameList.get(0) + girlNameList.get(0));
        }
        // 3. 生成男生的信息并添加到集合当中
        List<String> list = new ArrayList<>();
        Random r = new Random();
        // [18 ~ 27]
        for (String boy : boyName) {
            int age = r.nextInt(10) + 18;
            list.add(boy + "-男-" + age);
        }
        // 4. 生成女生的信息并添加到集合当中
        // [18 ~ 25]
        for (String girl : girlName) {
            int age = r.nextInt(8) + 18;
            list.add(girl + "-女-" + age);
        }
        return list;
    }

    /*
    * 作用: 根据正则表达式获取字符串中的数据
    * 参数一:
    *       完整的字符串
    * 参数二:
    *       正则表达式
    * 参数三:
    *       提取出的第几组数据
    * 返回值:
    *       真正想要的数据
    * */
    private static List<String> getData(String str, String regex, int index) {
        // 1. 创建集合存放数据
        List<String> list = new ArrayList<String>();
        // 2. 按照正则表达式的规则, 去获取数据
        Pattern pattern = Pattern.compile(regex);
        // 3. 按照pattern的规则, 到str当中获取数据
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group(index));
        }
        return list;
    }

    /*
    * 作用:
    *   从网络中爬取数据, 把数据拼接成字符串返回
    * 形参:
    *   网址
    * 返回值:
    *   爬取到的所有数据
    * */
    private static String webCrawler(String net) throws IOException {
        // 1. 定义StringBuilder拼接爬取到的数据
        StringBuilder sb = new StringBuilder();
        // 2. 创建一个URL对象
        URL url = new URL(net);
        // 3. 连接上这个网址
        // 细节: 保证网络是通畅的, 而且这个网址是可以连接上的
        URLConnection urlConnection = url.openConnection();
        // 4. 读取数据
        InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        // 5. 释放资源
        isr.close();
        // 6. 把读取到的数据返回
        return sb.toString();
    }

}
