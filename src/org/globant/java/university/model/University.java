package org.globant.java.university.model;

import org.globant.java.university.model.ext.Teacher;

import java.util.List;

public class University {

    private List<Teacher> teachers;
    private List<Student> students;
    private List<Subject> subjects;

    public University(List<Teacher> teachers, List<Student> students, List<Subject> subjects) {
        this.teachers = teachers;
        this.students = students;
        this.subjects = subjects;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }
}
