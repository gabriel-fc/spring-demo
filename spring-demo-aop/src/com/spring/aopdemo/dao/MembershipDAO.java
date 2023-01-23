package src.com.spring.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {
    public void addAccount(){
        System.out.println(getClass() + ": DOING STUF: ADDING A MEMBERSHIP");
    }



}
