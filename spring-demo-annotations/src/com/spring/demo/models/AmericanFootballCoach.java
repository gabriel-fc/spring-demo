package src.com.spring.demo.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import src.com.spring.demo.services.FortuneService;

@Component("wrongFootballCoach")
public class AmericanFootballCoach implements Coach{

    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "run and beat people, i dont care";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    @Autowired
    @Qualifier("happyFortuneService")

    public void setFortuneService( FortuneService fortuneService) {
        this.fortuneService = fortuneService;
    }
}
