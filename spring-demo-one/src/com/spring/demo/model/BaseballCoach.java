package src.com.spring.demo.model;

import src.com.spring.demo.service.FortuneService;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
        System.out.println("Baseball coach: inside constructor");
    }

    public String getDailyWorkout(){
        return "Spend 30 minutes on battig practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    private void cleanUpStuff(){
        System.out.println("Baseball coach: inside destroy method");
    }

    private void setUpStuff(){
        System.out.println("Baseball coach: inside init method");
    }
}
