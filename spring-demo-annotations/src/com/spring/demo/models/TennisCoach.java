package src.com.spring.demo.models;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import src.com.spring.demo.services.FortuneService;

@Component
public class TennisCoach implements Coach{

    private FortuneService fortuneService;

    @Autowired
    public TennisCoach(@Qualifier("someFortuneService") FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "just moans \"uuuuuuuh\" like guga";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
