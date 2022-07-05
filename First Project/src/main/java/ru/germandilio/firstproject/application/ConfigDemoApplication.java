package ru.germandilio.firstproject.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.germandilio.firstproject.Factory;

public class ConfigDemoApplication {
    public static void main(String[] args) {
        // load config from file
        var context = new ClassPathXmlApplicationContext("applicationConfig.xml");

        // retrieve bean from context
        var factory = context.getBean("mcDonaldFactory", Factory.class);

        System.out.println(factory.produce());

        context.close();
    }
}
