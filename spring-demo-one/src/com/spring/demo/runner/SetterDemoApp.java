package src.com.spring.demo.runner;

import src.com.spring.demo.model.CricketCoach;
import src.com.spring.demo.util.Context;

public class SetterDemoApp {
    public static void main(String[] args) {
        CricketCoach coach = Context.getContext().getBean("myCricketCoach", CricketCoach.class);
        System.out.println(coach.getDailyWorkout());
        System.out.println(coach.getDailyFortune());
        System.out.println(coach.getEmail());
        System.out.println(coach.getTeam());
    }
}
