package src.com.spring.demo.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class FilesFortuneService implements FortuneService{

    @Value("${fortune.message}")
    private String fortune;

    @Override
    public String getFortune() {
        return this.fortune;
    }
}
