package org.globant.java.university.model;

import org.globant.java.university.model.ext.Teacher;

public class TeacherPartTime extends Teacher {

    private float hoursPerWeek;

    public TeacherPartTime(String name, float baseSalary, float hoursPerWeek) {
        super(name, baseSalary);
    }

    @Override
    public float getSalaryCalculated() {
        return 0;
    }

    public float getHoursPerWeek() {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(float hoursPerWeek) {
        this.hoursPerWeek = hoursPerWeek;
    }
}
