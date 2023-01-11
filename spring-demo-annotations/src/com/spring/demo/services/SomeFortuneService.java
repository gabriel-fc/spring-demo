package src.com.spring.demo.services;

import org.springframework.stereotype.Component;

@Component
public class SomeFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "luck of the day: kanye west's twitter account is suspended";
    }
}
