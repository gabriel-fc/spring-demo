package src.com.spring.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import src.com.spring.demo.services.FortuneService;
@Component
public class FootballCoach implements Coach{

    @Autowired
    @Qualifier("happyFortuneService")
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "today will be a half-field practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
