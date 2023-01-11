package src.com.spring.demo.runners;

import src.com.spring.demo.models.Coach;
import src.com.spring.demo.util.Context;

public class FieldInjectionDemoApp {
    public static void main(String[] args) {
        Coach coach = Context.getContext().getBean("footballCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
    }
}
