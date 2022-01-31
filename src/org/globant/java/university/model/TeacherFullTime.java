package org.globant.java.university.model;

import org.globant.java.university.model.ext.Teacher;

public class TeacherFullTime extends Teacher {

    public TeacherFullTime(String name, float baseSalary) {
        super(name, baseSalary);
    }

    @Override
    public float getSalaryCalculated() {
        return 0;
    }
}
