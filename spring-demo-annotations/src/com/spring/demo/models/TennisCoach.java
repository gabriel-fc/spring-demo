package src.com.spring.demo.models;


import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{


    @Override
    public String getDailyWorkout() {
        return "just moans \"uuuuuuuh\" like guga";
    }

    @Override
    public String getDailyFortune() {
        return "no luck for you today";
    }
}
