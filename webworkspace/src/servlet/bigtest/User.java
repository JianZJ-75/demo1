package servlet.bigtest;

/**
 * @Author JianZJ
 * @Date 2024/6/29 20:34
 */
public class User {
    private String username;
    private String password;
    private String url;

    public User() {
    }

    public User(String username, String password, String url) {
        this.username = username;
        this.password = password;
        this.url = url;
    }

    /**
     * 获取
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
        url = UtilTools.repo + this.username + ".jpg";
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

    /**
     * 获取
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return "User{username = " + username + ", password = " + password + ", url = " + url + "}";
    }
}