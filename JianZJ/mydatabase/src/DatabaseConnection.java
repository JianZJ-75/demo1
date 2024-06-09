import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            // 加载JDBC驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 连接到数据库
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "readonlyuser@localhost", "123456");
            System.out.println("连接成功!");

            // 创建Statement对象
            statement = connection.createStatement();

            // 执行查询
            String query = "SELECT Student.StudentName, Student.DateOfBirth, Student.Major, Course.CourseName, Course.Credits, Course.Semester, Teacher.TeacherName, Teacher.Department FROM Enroll JOIN Student ON Enroll.StudentID = Student.StudentID JOIN Course ON Enroll.CourseID = Course.CourseID JOIN Teacher ON Course.TeacherID = Teacher.TeacherID;";
            ResultSet resultSet = statement.executeQuery(query);

            // 处理结果集
            while (resultSet.next()) {
                System.out.println("StudentName: " + resultSet.getString("StudentName") +
                        ", DateOfBirth: " + resultSet.getDate("DateOfBirth") +
                        ", Major: " + resultSet.getString("Major") +
                        ", CourseName: " + resultSet.getString("CourseName") +
                        ", Credits: " + resultSet.getInt("Credits") +
                        ", Semester: " + resultSet.getString("Semester") +
                        ", TeacherName: " + resultSet.getString("TeacherName") +
                        ", Department: " + resultSet.getString("Department"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}