package src.com.spring.demo.runner;

import src.com.spring.demo.model.Coach;
import src.com.spring.demo.util.Context;

public class MyApp {
    public static void main(String[] args) {
        Coach coach = Context.getContext().getBean("myOtherCoach", Coach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
    }
}
