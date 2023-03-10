package src.com.spring.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import src.com.spring.aopdemo.dao.AccountDAO;
import src.com.spring.aopdemo.dao.MembershipDAO;
import src.com.spring.aopdemo.models.Account;

public class MainDemoApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(DemoConfig.class);

        AccountDAO accountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
        accountDAO.addAccount();
        membershipDAO.addAccount();

        Account account = context.getBean("account", Account.class);

        account.getLogin();
        account.setLogin("login");
        context.close();
    }
}
