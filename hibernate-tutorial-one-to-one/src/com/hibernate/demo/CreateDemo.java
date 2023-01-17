package src.com.hibernate.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CreateDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(HibernateDemoConfig.class);
        DBSession session = context.getBean("getSession", DBSession.class);
    //        Instructor instructor = new Instructor
    //                ("joao", "instrutor", "otaldojoaozinhu@gmail.com");
    //        session.addObject(instructor);
        session.deleteObject(3);
    }
}
