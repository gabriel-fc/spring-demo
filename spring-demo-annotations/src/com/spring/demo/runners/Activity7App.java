package src.com.spring.demo.runners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import src.com.spring.demo.SportConfig;
import src.com.spring.demo.models.Coach;

public class Activity7App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new
                AnnotationConfigApplicationContext(SportConfig.class);
        Coach coach = context.getBean("valorantCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
    }
}
