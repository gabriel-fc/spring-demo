package src.com.spring.demo;

public class CricketCoach implements Coach{

    private FortuneService fortuneService;

    public CricketCoach(){}


    public void setFortuneService(FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "not much into training today";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
