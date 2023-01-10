package src.com.spring.demo.model;

import src.com.spring.demo.service.FortuneService;

public class TrackCoach implements Coach {
    private FortuneService fortuneService;

    public TrackCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return "Just do it! " + fortuneService.getFortune();
    }
}
