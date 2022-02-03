package org.globant.java.university.model;

import org.globant.java.university.model.fathers.Teacher;

public class FullTimeTeacher extends Teacher {

    private int experienceYears;
    private final int percentage = 110;

    public FullTimeTeacher(String name, float baseSalary, int experienceYears) {
        super(name, baseSalary);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    @Override
    public float getSalaryCalculated() {
        float hundredTenPercentYearsExperience = (this.experienceYears*this.percentage)/100;
        return getBaseSalary()*hundredTenPercentYearsExperience;
    }

    @Override
    public String toString() {
        return "FullTimeTeacher{" +
                "id=" + getId() +
                ", name=" + getName() +
                ", baseSalary=" + getBaseSalary() +
                ", experienceYears=" + this.experienceYears +
                '}';
    }
}
