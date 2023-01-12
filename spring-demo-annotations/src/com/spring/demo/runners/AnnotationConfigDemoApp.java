package src.com.spring.demo.runners;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import src.com.spring.demo.SportConfig;
import src.com.spring.demo.models.Coach;
import src.com.spring.demo.models.SwimCoach;

public class AnnotationConfigDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SportConfig.class);

        SwimCoach coach = context.getBean("swimCoach", SwimCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getTeam());
        System.out.println(coach.getEmail());
    }
}
