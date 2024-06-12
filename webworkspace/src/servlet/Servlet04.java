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
        BufferedReader br = request.getReader();
        String str = "";
        String tmp;
        while ((tmp = br.readLine()) != null) {
            str += tmp;
        }
        br.close();
        PrintWriter pw = response.getWriter();
        pw.println(str);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
