package iotest.test1;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/4/20 22:09
 */
public class Test2 {
    public static void main(String[] args) {
        // 利用糊涂包生成假数据, 并写到文件中

        // 1. 定义网址
        String familyNameNet = "https://hanyu.baidu.com/shici/detail?pid=0b2f26d4c0ddb3ee693fdb1137ee1b0d&amp;from=kg0";
        String boyNameNet = "http://www.haoming8.cn/baobao/10881.html";
        String girlNameNet = "http://www.haoming8.cn/baobao/7641.html";

        // 2. 爬取数据
        String familyNameStr = HttpUtil.get(familyNameNet);
        String boyNameStr = HttpUtil.get(boyNameNet);
        String girlNameStr = HttpUtil.get(girlNameNet);

        // 3. 利用正则表达式获取数据
        List<String> familyNameTempList = ReUtil.findAll("([\\u4E00-\\u9FA5]{4})(，|。)", familyNameStr, 1);
        List<String> boyNameTempList = ReUtil.findAll("([\\u4E00-\\u9FA5]{2})(、|。)", boyNameStr, 1);
        List<String> girlNameTempList = ReUtil.findAll("(.. ){4}..", girlNameStr, 0);

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

        // 6. 写出数据
        // 细节:
        // 糊涂包的相对路径, 不是相对于当前项目而言的, 而是相对class文件而言的
        FileUtil.writeLines(list, "E:\\Git\\demo1\\JianZJ\\myio\\src\\resource\\names.txt", "UTF-8", true);

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
}
