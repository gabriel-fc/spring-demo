package src.com.spring.demo.service;

import src.com.spring.demo.service.FortuneService;

public class HappyFortuneService implements FortuneService {
    @Override
    public String getFortune() {
        return "today is your lucky day!";
    }
}
