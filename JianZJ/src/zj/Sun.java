package zj;

/**
 * @Author: JianZJ
 * @Date: 2024/1/2 23:14
 */
public class Sun {
    protected int age;
    int num;
    public String name;
    public Sun(String name, int age, int num) {
        this.age = age;
        this.name = name;
        this.num = num;
    }
    public String toString() {
        return String.format(name + " " + age + " " + num);
    }
}
