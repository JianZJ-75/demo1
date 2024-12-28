package function.author;

import com.alibaba.fastjson2.JSON;
import function.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.Part;

import jakarta.servlet.http.HttpServletResponse;
import util.UtilTools;

import java.util.Base64;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.*;

/**
 * @Author JianZJ
 * @Date 2024/6/29 20:31
 */
@WebServlet(name = "RegisterCheck", urlPatterns = "/RegisterCheck")
@MultipartConfig
public class RegisterCheck extends HttpServlet {

    private boolean isImage(String contentType) {
        return contentType != null && (
                contentType.startsWith("image/jpeg") ||
                        contentType.startsWith("image/png") ||
                        contentType.startsWith("image/gif"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 用户名验证
        if (username == null || username.length() == 0) {
            out.println("{\"message\": \"用户名不能为空!\"}");
            return;
        } else if (username.length() >= 15) {
            out.println("{\"message\": \"用户名不能超过15位!\"}");
            return;
        }

        // 密码验证
        if (password == null || password.length() == 0) {
            out.println("{\"message\": \"密码不能为空!\"}");
            return;
        } else if (password.length() >= 20) {
            out.println("{\"message\": \"密码不能超过20位!\"}");
            return;
        }

        // 获取头像
        Part filePart = request.getPart("photo");

        if (filePart == null || filePart.getSize() == 0 || filePart.getSubmittedFileName().isEmpty()) {
            out.println("{\"message\": \"请选择头像!\"}");
            return;
        }

        String contentType = filePart.getContentType();
        if (!isImage(contentType)) {
            out.println("{\"message\": \"头像文件必须是图片格式！\"}");
            return;
        }

        long fileSize = filePart.getSize();
        System.out.println("File size: " + fileSize + " bytes");
        long maxSize = 35 * 1024;
        if (fileSize > maxSize) {
            out.println("{\"message\": \"头像文件不能大于35KB！\"}");
            return;
        }

        InputStream fileContent = filePart.getInputStream();
        byte[] bytes = fileContent.readAllBytes();
        String base64Photo = Base64.getEncoder().encodeToString(bytes);

        try {
            Class.forName(UtilTools.className);
            Connection connection = DriverManager.getConnection(UtilTools.url, UtilTools.user, UtilTools.password);

            // 如果用户已经存在
            String checkSql = UtilTools.checkSql;
            PreparedStatement checkStmt = connection.prepareStatement(checkSql);
            checkStmt.setString(1, username);
            ResultSet res = checkStmt.executeQuery();

            if (res.next()) {
                out.println("{\"message\": \"该用户名已经存在，请重新创建\"}");
            } else {
                // 添加新用户
                String insertSql = UtilTools.sqlAdd;
                PreparedStatement insertStmt = connection.prepareStatement(insertSql);
                insertStmt.setString(1, username);
                insertStmt.setString(2, password);
                insertStmt.setString(3, base64Photo);
                insertStmt.executeUpdate();

//                System.out.println(insertSql);
                out.println("{\"message\": \"创建成功!\"}");
            }

            res.close();
            checkStmt.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            out.println("{\"message\": \"Internal server error\"}");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String contentType = request.getContentType();
        if (contentType == null || !contentType.startsWith("multipart/form-data")) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().println("{\"message\": \"Invalid content type\"}");
            return;
        }

        // 继续处理请求
        doGet(request, response);
    }
}
