package org.globant.java.university.model;

import org.globant.java.university.model.ext.Teacher;

import java.util.List;

public class Subject {

    private String name;
    private String classRoom;
    private List<Student> students;
    private Teacher teacher;

    public Subject(String name, String classRoom, List<Student> students, Teacher teacher) {
        this.name = name;
        this.classRoom = classRoom;
        this.students = students;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
