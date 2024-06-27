package servlet.test5;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import servlet.Student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author JianZJ
 * @Date 2024/6/27 0:12
 */
@WebServlet(name = "Servlet", urlPatterns = "/update")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        String url = "jdbc:mysql://localhost:3306/test5";
        String username = "root";
        String password = "root";
        Connection connection = null;
        Statement statement = null;
        List<Book> books = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            statement = connection.createStatement();
            String sql = "select * from books left join press p on books.pressNum = p.pressNum";
            ResultSet res = statement.executeQuery(sql);
            while (res.next()) {
                Book book = new Book();
                book.setNum(res.getString("num"));
                book.setName(res.getString("books.name"));
                book.setAuthor(res.getString("author"));
                book.setPressName(res.getString("p.name"));
                book.setPrice(res.getDouble("price"));
                book.setIntro(res.getString("intro"));
                books.add(book);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        pw.println(JSON.toJSONString(books));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
