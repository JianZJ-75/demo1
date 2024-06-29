package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.*;

/**
 * @Author JianZJ
 * @Date 2024/6/12 20:05
 */
@WebServlet(name = "Servlet03", urlPatterns = "/test1")
public class Servlet03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
//        String name = request.getParameter("name");
//        if (name != null) {
//            FileWriter fw = new FileWriter(new File("webworkspace\\src\\resource\\servlet\\tmp.txt"));
//            fw.write("zj");
//            fw.close();
//        }
        File file = new File("E:\\Git\\demo1\\webworkspace\\src\\resource\\servlet\\tmp.txt");
        FileWriter fw = new FileWriter(file);
        fw.write("zjzjzjzjzjzj");
        fw.close();
//        FileReader fr = new FileReader(file);
//        char[] chars = new char[2];
//        int len;
//        String res = "";
//        while ((len = fr.read(chars)) != -1) {
//            res += new String(chars, 0, len);
//        }
//        pw.println(res + " " + file.getAbsolutePath() + " " + file.getPath());
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
