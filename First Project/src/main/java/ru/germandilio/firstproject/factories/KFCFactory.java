package ru.germandilio.firstproject.factories;

import org.springframework.stereotype.Component;
import ru.germandilio.firstproject.suppiers.EnergySupplier;

public class KFCFactory implements Factory {
    private final EnergySupplier energySupplier;

    public KFCFactory(EnergySupplier energySupplier) {
        this.energySupplier = energySupplier;
    }

    @Override
    public String produce() {
        energySupplier.getEnergy(10);
        return "New Chicken legs";
    }
}
