package src.com.spring.jdbc;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.com.hibernate.demo.entity.models.Student;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
                .configure("src/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Student student = new Student("marina",
                    "Sena", "prim@gmail.com");
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
        }catch (Exception e){
            factory.close();
        }
    }
}
