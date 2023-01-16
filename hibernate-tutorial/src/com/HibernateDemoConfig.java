package src.com;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import src.com.hibernate.demo.entity.Student;
import src.com.hibernate.demo.service.DBSession;

@Configuration
public class HibernateDemoConfig {


    @Bean
    public SessionFactory getSessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("src/hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
    }

    @Bean
    public DBSession getSession(){
        return new DBSession<>(Student.class);
    }
}
