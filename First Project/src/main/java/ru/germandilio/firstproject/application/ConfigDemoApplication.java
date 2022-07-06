package ru.germandilio.firstproject.application;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.germandilio.firstproject.factories.Factory;

public class ConfigDemoApplication {
    public static void main(String[] args) {
        // load config from file
        var context = new ClassPathXmlApplicationContext("applicationConfig.xml");

        // retrieve bean from context
        var mcDonaldFactory = context.getBean("mcDonaldFactory", Factory.class);
        System.out.println(mcDonaldFactory.produce());

        var kfcFactory = context.getBean("kfcFactory", Factory.class);
        System.out.println(kfcFactory.produce());

        context.close();
    }
}
