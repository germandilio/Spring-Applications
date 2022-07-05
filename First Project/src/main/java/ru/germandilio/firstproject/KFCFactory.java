package ru.germandilio.firstproject;

import java.util.Random;

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
