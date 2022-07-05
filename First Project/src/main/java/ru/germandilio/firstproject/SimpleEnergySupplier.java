package ru.germandilio.firstproject;

public class SimpleEnergySupplier implements EnergySupplier {
    private int energy;

    public SimpleEnergySupplier(int initialEnergy) {
        this.energy = initialEnergy;
    }

    @Override
    public boolean getEnergy(int amount) {
        if (energy < amount) {
            return false;
        }

        energy -= amount;
        return true;
    }
}
