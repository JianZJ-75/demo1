import java.sql.*;

/**
 * @Author JianZJ
 * @Date 2024/6/9 22:11
 */

public class Main {
    public static void main(String[] args) {
        // 数据库连接参数
        String url = "jdbc:mysql://localhost:3306/database_test";
        String username = "consumer_user";
        String password = "123456";

        // 尝试连接数据库
        try {
            // 加载JDBC驱动程序
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立连接
            Connection conn = DriverManager.getConnection(url, username, password);

            // 创建 Statement 对象
            Statement stmt = conn.createStatement();

            // 执行 SQL 查询
            String sql = "SELECT Users.UserName, Orders.OrderDate, Books.BookName, Books.Author, Books.Price, OrderDetails.Quantity " +
                         "FROM Users " +
                         "JOIN Orders ON Users.UserID = Orders.UserID " +
                         "JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID " +
                         "JOIN Books ON OrderDetails.BookID = Books.BookID";
            ResultSet rs = stmt.executeQuery(sql);

            // 处理结果
            while (rs.next()) {
                String userName = rs.getString("UserName");
                Date orderDate = rs.getDate("OrderDate");
                String bookName = rs.getString("BookName");
                String author = rs.getString("Author");
                double price = rs.getDouble("Price");
                int quantity = rs.getInt("Quantity");

                // 输出结果
                System.out.println("用户名: " + userName + ", 订单日期: " + orderDate +
                                   ", 图书名称: " + bookName + ", 图书作者: " + author +
                                   ", 图书价格: " + price + ", 数量: " + quantity);
            }

            // 关闭连接
            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
