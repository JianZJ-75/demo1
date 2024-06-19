package servlet;

/**
 * @Author JianZJ
 * @Date 2024/6/19 18:36
 */
public class Student {
    private String num;
    private String name;
    private int sex;
    private int age;

    public Student() {
    }

    public Student(String num, String name, int sex, int age) {
        this.num = num;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    /**
     * 获取
     * @return num
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(String num) {
        this.num = num;
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
     * @return sex
     */
    public int getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(int sex) {
        this.sex = sex;
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

    public String toString() {
        return "Student{num = " + num + ", name = " + name + ", sex = " + sex + ", age = " + age + "}";
    }
}