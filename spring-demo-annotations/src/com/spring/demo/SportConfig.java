package src.com.spring.demo;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import src.com.spring.demo.models.Coach;
import src.com.spring.demo.models.SwimCoach;
import src.com.spring.demo.services.FortuneService;
import src.com.spring.demo.services.HappyFortuneService;


@Configuration
@PropertySource("classpath:src/com/spring/demo/properties/sport.properties")
//@ComponentScan("src.com.spring.demo") -> because we are using @bean annotation, there's no need to scan the project
public class SportConfig {
    @Bean
    @Scope("prototype")
    public Coach swimCoach(){
        SwimCoach swimCoach = new SwimCoach(happyFortuneService());
        return swimCoach;
    }

    @Bean
    public FortuneService happyFortuneService(){
       return new HappyFortuneService();
    }


}
