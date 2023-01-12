package src.com.spring.demo.models;

import org.springframework.beans.factory.annotation.Value;
import src.com.spring.demo.services.FortuneService;

public class SwimCoach implements Coach {

    private FortuneService fortuneService;

    @Value("${sport.email}")
    private String email;
    @Value("${sport.team}")
    private String team;


    public SwimCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }


    @Override
    public String getDailyWorkout() {
        return "today let's do 50 push-ups";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public String getEmail() {
        return email;
    }
}
