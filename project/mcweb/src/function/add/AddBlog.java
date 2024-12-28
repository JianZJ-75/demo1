package function.add;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.UtilTools;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @Author JianZJ
 * @Date 2024/6/29 20:13
 */
@WebServlet(name = "AddBlog", urlPatterns = "/AddBlog")
public class AddBlog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        // 获取博客信息
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String username = request.getParameter("username");

        // 标题验证
        if (title == null || title.length() == 0) {
            out.println("{\"message\": \"标题不能为空!\"}");
            return;
        } else if (title.length() >= 15) {
            out.println("{\"message\": \"标题长度不能大于20!\"}");
            return;
        }

        // 内容验证
        if (content == null || content.length() == 0) {
            out.println("{\"message\": \"内容不能为空!\"}");
            return;
        }

        System.out.println(title + " " + content + " " + username);
        try {
            Class.forName(UtilTools.className);
            Connection connection = DriverManager.getConnection(UtilTools.url, UtilTools.user, UtilTools.password);
            // 创建博客
            PreparedStatement ps = connection.prepareStatement(UtilTools.sqlAddBlog);
            ps.setString(1, title);
            ps.setString(2, username);
            ps.setString(3, content);
            ps.executeUpdate();
            // 添加成功
            out.println("{\"message\": \"添加成功!\"}");
            ps.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
