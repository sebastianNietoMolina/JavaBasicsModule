package org.globant.java.university.model;

import org.globant.java.university.model.fathers.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private int id;
    private static int counter = 0;
    private String name;
    private String classRoom;
    private List<Student> studentList;
    private Teacher teacher;

    public Subject() {
    }

    public Subject(String name, String classRoom, List<Student> studentList, Teacher teacher) {
        this.name = name;
        this.classRoom = classRoom;
        this.studentList = studentList;
        this.teacher = teacher;
        this.id = this.counter;
        this.counter += 1;
    }

    public void addStudent(Student student) {
        List<Student> newStudentList = new ArrayList<>();
        newStudentList.addAll(studentList);
        newStudentList.add(student);
        setStudents(newStudentList);
    }

    public boolean isStudentInSubject(Student student) {
        boolean studentExist = false;
        for (int i = 0; i < this.studentList.size() && !studentExist; i++) {
            if (this.studentList.get(i).equals(student)) {
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
        return studentList;
    }

    public void setStudents(List<Student> studentList) {
        this.studentList = studentList;
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
                "\n id=" + this.id +
                "\n name=" + this.name +
                "\n classRoom=" + this.classRoom +
                "\n students=" + this.studentList +
                "\n teacher=" + this.teacher +
                "\n}";
    }
}
