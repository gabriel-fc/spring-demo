package src.com.spring.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import src.com.spring.demo.services.FortuneService;


@Component
class VolleyCoach implements Coach {

    @Autowired
    @Qualifier("filesFortuneService")
    private FortuneService fortuneService;
    @Override
    public String getDailyWorkout() {
        return "You just got gibed";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}