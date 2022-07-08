package ru.germandilio.annotationsbasedconfiguration.firstproject.factories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.germandilio.annotationsbasedconfiguration.firstproject.suppiers.EnergySupplier;

@Component
public class KFCFactory implements Factory {
    private final EnergySupplier energySupplier;

    @Autowired
    public KFCFactory(@Qualifier("simpleEnergySupplier") EnergySupplier energySupplier) {
        this.energySupplier = energySupplier;
    }

    @Override
    public String produce() {
        energySupplier.getEnergy(10);
        return "New Chicken legs";
    }
}
