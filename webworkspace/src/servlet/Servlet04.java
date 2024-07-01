package servlet;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Objects;

/**
 * @Author JianZJ
 * @Date 2024/6/12 23:06
 */
@WebServlet(name = "Servlet04", urlPatterns = "/test2")
public class Servlet04 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter pw = response.getWriter();
        pw.println(request.getParameter("name") + " " + request.getParameter("age"));
        System.out.println(request.getParameter("name") + " " + request.getParameter("age"));
//        response.sendRedirect("test/test1/test3.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
