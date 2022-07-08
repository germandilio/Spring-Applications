package ru.germandilio.annotationsbasedconfiguration.firstproject.suppiers;

import org.springframework.stereotype.Component;

/**
 * Simple version of {@link EnergySupplier}.
 */
@Component
public class SimpleEnergySupplier implements EnergySupplier {
    private int energy = 100;

    @Override
    public boolean getEnergy(int amount) {
        if (energy < amount) {
            return false;
        }

        energy -= amount;
        return true;
    }
}
