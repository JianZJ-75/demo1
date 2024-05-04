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

        List<User> list = new ArrayList<>();
        list.add(new User("zj", "123"));
        for (User user : list) {
            user.setName("abc");
        }
        System.out.println(list.get(0));
    }
}

class User {

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
        return "User{name = " + name + ", password = " + password + "}";
    }
}