package src.com.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import src.com.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("src/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();
        try {
            Student student1 = new Student("vovô",
                    "nena", "seaposente@gmail.com");
            Student student2 = new Student("abc",
                    "da silva", "abc@gmail.com");
            Student student3 = new Student("def",
                    "dos santos", "def@gmail.com");
            session.beginTransaction();
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.getTransaction().commit();
        }catch (Exception e){
            factory.close();
        }
    }
}

