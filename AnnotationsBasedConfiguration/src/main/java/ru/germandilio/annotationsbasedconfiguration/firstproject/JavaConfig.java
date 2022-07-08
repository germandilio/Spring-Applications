package ru.germandilio.annotationsbasedconfiguration.firstproject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.germandilio.annotationsbasedconfiguration.firstproject.factories.Factory;
import ru.germandilio.annotationsbasedconfiguration.firstproject.factories.KFCFactory;
import ru.germandilio.annotationsbasedconfiguration.firstproject.factories.McDonaldFactory;
import ru.germandilio.annotationsbasedconfiguration.firstproject.suppiers.EnergySupplier;
import ru.germandilio.annotationsbasedconfiguration.firstproject.suppiers.SimpleEnergySupplier;

@Configuration
@ComponentScan("ru.germandilio.annotationsbasedconfiguration.firstproject")
@PropertySource("classpath:factory.properties")
public class JavaConfig {
    @Bean
    public Factory mcDonaldFactory() {
        return new McDonaldFactory(simpleEnergySupplier());
    }

    @Bean
    public Factory kfcFactory() {
        return new KFCFactory(simpleEnergySupplier());
    }

    @Bean
    public EnergySupplier simpleEnergySupplier() {
        return new SimpleEnergySupplier();
    }
}
