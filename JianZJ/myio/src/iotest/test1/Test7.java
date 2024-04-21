package iotest.test1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/4/21 20:56
 */
public class Test7 {
    public static void main(String[] args) throws IOException {
        /*
        * 随机点名器5(课堂讲解)
        *
        * TxT文件中事先准备好一些学生信息, 每个学生的信息独占一行
        * 要求1: 每次被点到的学生, 再次被点到的概率在原先的基础上降低一半
        *
        * 举例: 80个学生, 点名5次, 每次都点到小A, 概率变化情况如下:
        *       第一次每人概率: 1.25%
        *       第二次小A概率: 0.625%         其他学生概率: 1.2579%
        *       第三次小A概率: 0.3125%        其他学生概率: 1.261867%
        *       第四次小A概率: 0.15625%       其他学生概率: 1.2638449%
        *       第五次小A概率: 0.078125%      其他学生概率: 1.26483386%
        *
        * 提示: 本体的核心就是带权的随机
        *       本题需要用到集合, IO, 权重随机算法
        * */

        // 1. 把文件中所有的学生信息读取到内存中
        File file = new File("myio\\src\\resource\\names.txt");
        List<Student> students = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] infos = line.split("-");
            students.add(new Student(infos[0], infos[1], Integer.parseInt(infos[2]), Double.parseDouble(infos[3])));
        }
        br.close();

        // 2. 计算权重的总和
        double weight = 0;
        for (Student student : students) {
            weight += student.getWeight();
        }

        // 3. 计算每一个人的实际占比
        double[] weights = new double[students.size()];
        for (int i = 0; i < students.size(); i++) {
            weights[i] = students.get(i).getWeight() / weight;
        }

        // 4. 计算每一个人的权重占比范围
        for (int i = 1; i < weights.length; i++) {
            weights[i] = weights[i - 1] + weights[i];
        }

        // 5. 随机抽取
        // 获取一个[0.0, 1.0)之间的随机数
        double num = Math.random();
        // 判断num在weights中的位置
        // 二分查找
        int index = search(weights, num);

        // 6. 修改当前学生的权重
        Student stu = students.get(index);
        System.out.println(stu);
        stu.setWeight(stu.getWeight() / 2);

        // 7. 把集合中的数据再次写到文件中
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        for (Student student : students) {
            bw.write(student.toString());
            bw.newLine();
        }
        bw.close();

    }

    private static int search(double[] weights, double num) {
        int l = 0, r = weights.length;
        while (r - l > 1) {
            int mid = (l + r) / 2;
            if (num < weights[mid]) {
                r = mid;
            } else {
                l = mid;
            }
        }
        return l + 1;
    }

}

class Student {
    private String name;
    private String gender;
    private int age;
    private double weight;

    public Student() {
    }

    public Student(String name, String gender, int age, double weight) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
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
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return weight
     */
    public double getWeight() {
        return weight;
    }

    /**
     * 设置
     * @param weight
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String toString() {
        return name + "-" + gender + "-" + age + "-" + weight;
    }

}
