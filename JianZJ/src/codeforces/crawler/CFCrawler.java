package codeforces.crawler;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.io.*;
import java.util.*;

/**
 * @Author JianZJ
 * @Date 2024/4/22 11:42
 */
public class CFCrawler {
    public static void main(String[] args) throws IOException {
        String net = "https://codeforces.com/profile/";
        String dest = "E:\\Git\\demo1\\JianZJ\\src\\resource\\acmlist.txt";

        // 获取名单
        List<String> list = getList(dest);

        // 分析数据
        List<Acmer> acmers = processData(list);

        // 获取rating
        getRating(acmers, net);

        // 按rating排序
        Collections.sort(acmers, (o1, o2) -> o2.getCfRating() - o1.getCfRating());

        // 更新数据
        writeData(acmers, dest);

    }

    private static void writeData(List<Acmer> acmers, String dest) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(dest));
        for (Acmer acmer : acmers) {
            bw.write(acmer.toString());
            bw.newLine();
        }
        bw.close();
    }

    private static void getRating(List<Acmer> acmers, String net) {
        for (Acmer acmer : acmers) {
            String str = HttpUtil.get(net + acmer.getName());
            List<String> all = ReUtil.findAll("max. <span style=\"font-weight:([A-Za-z]+);\" class=\"user-([A-Za-z]+)\">([A-Za-z]+), </span> <span style=\"font-weight:([A-Za-z]+);\" class=\"user-([A-Za-z]+)\">([0-9]+)</span>", str, 6);
            acmer.setCfRating(Integer.parseInt(all.get(0)));
        }
    }

    private static List<Acmer> processData(List<String> list) {
        List<Acmer> acmers = new ArrayList<>();
        for (String s : list) {
            String[] infos = s.split("-");
            acmers.add(new Acmer(infos[0], infos[1], Integer.parseInt(infos[2])));
        }
        return acmers;
    }

    private static List<String> getList(String dest) throws IOException {
        List<String> list = new ArrayList<>();
        String line;
        BufferedReader br = new BufferedReader(new FileReader(dest));
        while ((line = br.readLine()) != null) {
            list.add(line);
        }
        br.close();
        return list;
    }

}

class Acmer {
    private String realName;
    private String name;
    private int cfRating;

    public Acmer() {
    }

    public Acmer(String realName, String name, int cfRating) {
        this.realName = realName;
        this.name = name;
        this.cfRating = cfRating;
    }

    /**
     * 获取
     * @return realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return cfRating
     */
    public int getCfRating() {
        return cfRating;
    }

    /**
     * 设置
     * @param cfRating
     */
    public void setCfRating(int cfRating) {
        this.cfRating = cfRating;
    }

    public String toString() {
        return realName + "-" + name + "-" + cfRating;
    }

}