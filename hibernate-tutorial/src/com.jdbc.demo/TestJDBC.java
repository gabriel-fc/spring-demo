package src.com.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String usr = "hbstudent";
        String password = "hbstudent";
        try {
            System.out.println("connecting to db: " + jdbcUrl);
            Connection mycon = DriverManager.getConnection(jdbcUrl, usr, password);
            System.out.println("connection successful ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
