package src.com.spring.demo.util;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Context {
    private static Context instance;
    private final ClassPathXmlApplicationContext context;
    private Context(){
        context =
                new ClassPathXmlApplicationContext("src/com/spring/demo/" +
                        "context/applicationContext.xml");

    }

    public static ClassPathXmlApplicationContext getContext(){
        if(instance == null) instance = new Context();
        return instance.context;
    }
}
