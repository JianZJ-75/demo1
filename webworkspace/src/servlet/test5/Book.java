package servlet.test5;

/**
 * @Author JianZJ
 * @Date 2024/6/27 0:11
 */
public class Book {
    private String num;
    private String name;
    private String author;
    private String pressName;
    private double price;
    private String intro;

    public Book() {
    }

    public Book(String num, String name, String author, String pressName, double price, String intro) {
        this.num = num;
        this.name = name;
        this.author = author;
        this.pressName = pressName;
        this.price = price;
        this.intro = intro;
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
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取
     * @return pressName
     */
    public String getPressName() {
        return pressName;
    }

    /**
     * 设置
     * @param pressName
     */
    public void setPressName(String pressName) {
        this.pressName = pressName;
    }

    /**
     * 获取
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * 获取
     * @return intro
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置
     * @param intro
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String toString() {
        return "Book{num = " + num + ", name = " + name + ", author = " + author + ", pressName = " + pressName + ", price = " + price + ", intro = " + intro + "}";
    }
}