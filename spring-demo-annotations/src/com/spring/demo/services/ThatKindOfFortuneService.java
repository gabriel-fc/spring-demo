package src.com.spring.demo.services;

public class ThatKindOfFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "Luck of the day: Chamber was nerfed";
    }
}
