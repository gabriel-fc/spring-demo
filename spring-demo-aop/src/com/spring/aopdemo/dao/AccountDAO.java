package src.com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(){
        System.out.println(getClass() + ": Doing my db work: adding an account");
    }
}
