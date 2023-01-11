package src.com.spring.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import src.com.spring.demo.services.FortuneService;

public interface Coach {
    String getDailyWorkout();
    String getDailyFortune();

}
