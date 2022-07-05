package ru.germandilio.firstproject;

public class KFCFactory implements Factory {
    @Override
    public String produce() {
        return "New Chicken legs";
    }
}
