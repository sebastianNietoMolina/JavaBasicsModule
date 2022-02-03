package org.globant.java.university.model.fathers;

public abstract class Teacher {

    private int id;
    private static int counter = 0;
    private String name;
    private float baseSalary;

    public Teacher(String name, float baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.id = this.counter;
        this.counter += 1;
    }

    public abstract float getSalaryCalculated();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        this.baseSalary = baseSalary;
    }
}
