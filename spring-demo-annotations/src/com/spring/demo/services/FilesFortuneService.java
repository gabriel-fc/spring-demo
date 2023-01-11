package src.com.spring.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import src.com.spring.demo.controllers.FortuneController;

import java.util.Random;

@Component
public class FilesFortuneService implements FortuneService{

    private String[] fortune;
    @Override
    public String getFortune() {
        return fortune[getRandomIndex()];
    }



    private int getRandomIndex(){
        Random gen = new Random(System.currentTimeMillis());
        return gen.nextInt(fortune.length);
    }

    @Autowired
    public void setFortune(FortuneController controller) {
        this.fortune = controller.getText().split(",");
    }
}
