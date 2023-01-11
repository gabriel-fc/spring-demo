package src.com.spring.demo.runners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import src.com.spring.demo.SportConfig;

public class AnnotationConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        System.out.println(context.getBean("volleyCoach"));
    }
}
