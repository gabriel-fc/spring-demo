package src.com.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * src.com.spring.aopdemo.dao.*.addAccount())")
    public void addAccountAdvice(){
        System.out.println("\n=============>>>> Executing @Before advice on addAccount");
    }

}
