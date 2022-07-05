package ru.germandilio.firstproject;

public class McDonaldFactory implements Factory {
    private String address;
    private String email;

    private final EnergySupplier energySupplier;

    public McDonaldFactory(EnergySupplier energySupplier) {
        this.energySupplier = energySupplier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String produce() {
        final int amountOfEnergy = 10;
        energySupplier.getEnergy(amountOfEnergy);

        return String.format("New Big Tasty. Energy used: %d", amountOfEnergy);
    }
}
