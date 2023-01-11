package src.com.spring.demo.controllers;


import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Component
public class FortuneController {
    private BufferedReader reader;
    private final String filePath = "src/com/spring/demo/fortunes.txt";

    @PreDestroy()
    public void closeReader(){
        System.out.println("inside destroy method");
        try {
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    private void setUpReader(){
        System.out.println("inside init method");
        try{
            this.reader = new BufferedReader(new FileReader(filePath));
        }catch (FileNotFoundException e){
            throw new RuntimeException("fortunes.txt not found", e);
        }
    }


    public String getText(){
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException("error on reading line", e);
        }

    }
}
