package org.globant.java.university.model;

import org.globant.java.university.model.ext.Teacher;

import java.util.List;

public class Subject {

    private int id;
    private static int counter = 0;
    private String name;
    private String classRoom;
    private List<Student> subjectList;
    private Teacher teacher;

    public Subject() {
    }

    public Subject(String name, String classRoom, List<Student> subjectList, Teacher teacher) {
        this.name = name;
        this.classRoom = classRoom;
        this.subjectList = subjectList;
        this.teacher = teacher;
        this.id = this.counter;
        this.counter += 1;
    }

    public void addStudent(Student student) {
        this.subjectList.add(student);
    }

    public boolean isStudentInSubject(Student student) {
        boolean studentExist = false;
        for (int i = 0; i < this.subjectList.size() && !studentExist; i++) {
            if (this.subjectList.get(i).equals(student)) {
                studentExist = true;
            }
        }

        return studentExist;
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

    public String getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(String classRoom) {
        this.classRoom = classRoom;
    }

    public List<Student> getStudents() {
        return subjectList;
    }

    public void setStudents(List<Student> subjectList) {
        this.subjectList = subjectList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + this.id +
                ", name=" + this.name +
                ", classRoom=" + this.classRoom +
                ", students=" + this.subjectList +
                ", teacher=" + this.teacher +
                '}';
    }
}
