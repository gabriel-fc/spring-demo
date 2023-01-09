package src.com.spring.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("src/com/spring/demo/applicationContext.xml");

        Coach coach = context.getBean("MyCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
    }
}
