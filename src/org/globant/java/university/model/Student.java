package org.globant.java.university.model;

public class Student {

    private int id;
    private static int counter = 0;
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = this.counter;
        this.counter += 1;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + this.id +
                ", name=" + this.name +
                ", age=" + this.age +
                '}';
    }
}
