package ru.germandilio.annotationsbasedconfiguration.firstproject.suppiers;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class ComplexEnergySupplier implements EnergySupplier {
    private static final int MAX_ENERGY_WITHDRAWAL = 10;
    public static final int MIN_ENERGY_WITHDRAWAL = 0;

    private final Random random = new Random();
    private int initialEnergy = 100;

    @Override
    public boolean getEnergy(int amount) {
        final boolean wasEnough = random.nextBoolean();
        if (!wasEnough) {
            return false;
        }

        initialEnergy -= random.nextInt(MIN_ENERGY_WITHDRAWAL, MAX_ENERGY_WITHDRAWAL);
        return wasEnough;
    }
}
