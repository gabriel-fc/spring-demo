package src.com.spring.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import src.com.spring.demo.services.FortuneService;

public class ValorantCoach implements Coach {

    @Autowired
    @Qualifier("thatKindOfFortuneService")
    FortuneService fortuneService;


    @Override
    public String getDailyWorkout() {
        return "shoot 100 times in the bot head";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
