package ru.germandilio.annotationsbasedconfiguration.firstproject.application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.germandilio.annotationsbasedconfiguration.firstproject.JavaConfig;
import ru.germandilio.annotationsbasedconfiguration.firstproject.factories.Factory;

public class ConfigDemoApplication {
    public static void main(String[] args) {
        // load config from Java class (NO XML!!!)
        var context = new AnnotationConfigApplicationContext(JavaConfig.class);

        // retrieve bean from context
        var mcDonaldFactory = context.getBean("mcDonaldFactory", Factory.class);
        System.out.println(mcDonaldFactory.produce());

        var secondMcDonaldFactory = context.getBean("mcDonaldFactory", Factory.class);
        System.out.println(secondMcDonaldFactory.produce());

        var kfcFactory = context.getBean("KFCFactory", Factory.class);
        System.out.println(kfcFactory.produce());

        // check that beans are different, which will prove "prototype" behavior
        System.out.println("mcDonaldFactory == secondMcDonaldFactory: " + (mcDonaldFactory == secondMcDonaldFactory));
        System.out.println("mcDonaldFactory=" + mcDonaldFactory);
        System.out.println("secondMcDonaldFactory=" + secondMcDonaldFactory);

        context.close();
    }
}
