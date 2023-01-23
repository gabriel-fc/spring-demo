package src.com.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* src.com.spring.aopdemo.models.Account.*(..))")
    public void forAllAccountMethods(){}

    @Pointcut("execution(* src.com.spring.aopdemo.models.Account.set*(..))")
    public void forAllAccountSetterMethods(){}

    @Pointcut("forAllAccountMethods() && !forAllAccountSetterMethods()")
    public void forAllAccountMethodsExceptSetters(){}

    @Before("execution(public * src.com.spring.aopdemo.dao.*.addAccount())")

    public void addAccountAdvice(){
        System.out.println("\n=============>>>> Executing @Before advice on addAccount");
    }

    @Before("forAllAccountMethodsExceptSetters()")
    public void setUpAccountMethod(){
        System.out.println("\n=============>>>> Executing @Before advice on Account methods");
    }
}
