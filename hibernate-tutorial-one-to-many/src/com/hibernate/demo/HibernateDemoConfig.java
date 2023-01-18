package src.com.hibernate.demo;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import src.com.hibernate.demo.entity.Course;
import src.com.hibernate.demo.entity.Instructor;
import src.com.hibernate.demo.entity.InstructorDetail;

@Configuration
public class HibernateDemoConfig {


    @Bean(destroyMethod = "close")
    public SessionFactory getSessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("src/hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();
    }

    @Bean(destroyMethod = "close")
    public DBSession getSession(){
        return new DBSession<>(Course.class);
    }

}
