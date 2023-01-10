package src.com.spring.demo.service;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class RandomFortuneService implements FortuneService{
    private String[] fortunes;
    @Override
    public String getFortune() {
        return fortunes[getRandomIndex()];
    }

    private int getRandomIndex(){
        Random gen = new Random(System.currentTimeMillis());
        return gen.nextInt(fortunes.length);
    }

    public void setFortunes(String[] fortunes) {
        this.fortunes = fortunes;
    }
}
