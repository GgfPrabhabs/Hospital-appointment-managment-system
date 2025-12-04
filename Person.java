package model;

public abstract class Person {
    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract String getDetails(); // Polymorphism

    public String getName() {
        return name;
    }
}
