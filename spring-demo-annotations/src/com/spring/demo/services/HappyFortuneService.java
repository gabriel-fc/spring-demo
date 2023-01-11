package src.com.spring.demo.services;



import org.springframework.stereotype.Component;
@Component
public class HappyFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "dont leave your house";
    }
}
