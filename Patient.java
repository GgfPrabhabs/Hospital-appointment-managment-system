package model;

public class Patient extends Person {

    public Patient(String name) {
        super(name);
    }

    @Override
    public String getDetails() {
        return "Patient: " + name;
    }
}
