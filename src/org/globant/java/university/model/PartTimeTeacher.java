package org.globant.java.university.model;

import org.globant.java.university.model.ext.Teacher;

public class PartTimeTeacher extends Teacher {

    private float hoursPerWeek;

    public PartTimeTeacher(String name, float baseSalary, float hoursPerWeek) {
        super(name, baseSalary);
    }

    public float getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(float hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }

    @Override
    public float getSalaryCalculated() {
        return getBaseSalary()*this.hoursPerWeek;
    }

    @Override
    public String toString() {
        return "PartTimeTeacher{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", baseSalary=" + getBaseSalary() +
                ", hoursPerWeek=" + this.hoursPerWeek +
                '}';
    }
}
