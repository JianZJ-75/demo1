import java.io.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: JianZJ
 * @Date: 2024/1/9 15:37
 */

public class Main {

    static final int K = 828;

    public static void main(String[] args) throws IOException {

        List<User[]> list = new ArrayList<>();
        list.add(new User[]{new User("zj", "zj"), new User("hcc", "hcc"), new User("zyd", "zyd")});
        Object[][] o= list.stream().toArray(value -> new Object[value][]);
        for (Object[] objects : o) {
            System.out.println(Arrays.toString(objects));
        }
//        List<Object[]> tabledatas = new ArrayList<>();
//        tabledatas.add(new Object[]{"编号1", "标题1", "正文1"});
//
//        //定义表格组件
//        //并给表格设置标题和内容
//        Object[][] o = tabledatas.stream().toArray(value -> new Object[value][]);
//        for (Object[] objects : o) {
//            System.out.println(Arrays.toString(objects));
//        }
    }
}

class User implements Serializable{

    @Serial
    private static final long serialVersionUID = -2513747641863637392L;

    private String name;
    private String password;

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return "User{serialVersionUID = " + serialVersionUID + ", name = " + name + ", password = " + password + "}";
    }
}