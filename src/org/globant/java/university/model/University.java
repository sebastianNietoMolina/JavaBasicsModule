package org.globant.java.university.model;

import org.globant.java.university.model.fathers.Teacher;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Subject> subjectList;

    public University(List<Teacher> teacherList, List<Student> studentList, List<Subject> subjectList) {
        this.teacherList = teacherList;
        this.studentList = studentList;
        this.subjectList = subjectList;
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public void addSubject(Subject subject) {
        this.subjectList.add(subject);
    }

    public void addStudentToSubject(Student student, int subjectId) {
        boolean existSubject = false;
        for (int i = 0; i < this.subjectList.size() && !existSubject; i++) {
            if (this.subjectList.get(i).getId() == subjectId) {
                this.subjectList.get(i).addStudent(student);
                existSubject = true;
            }
        }
    }

    public Subject getSubjectById(int subjectId) {
        Subject subject = new Subject();
        boolean existSubject = false;
        for (int i = 0; i < this.subjectList.size() && !existSubject; i++) {
            if (this.subjectList.get(i).getId() == subjectId) {
                subject = this.subjectList.get(i);
                existSubject = true;
            }
        }

        return subject;
    }

    public Teacher getTeacherById(int teacherId) {
        Teacher teacher = null;
        boolean existTeacher = false;
        for (int i = 0; i < this.teacherList.size() && !existTeacher; i++) {
            if (this.teacherList.get(i).getId() == teacherId) {
                teacher = this.teacherList.get(i);
                existTeacher = true;
            }
        }

        return teacher;
    }

    public List<Subject> getSubjectsByGivenStudent(Student student) {
        List<Subject> subjectsByStudent = new ArrayList<>();
        for (Subject subject : this.subjectList) {
            if (subject.isStudentInSubject(student)) {
                subjectsByStudent.add(subject);
            }
        }

        return subjectsByStudent;
    }

    public List<Teacher> getTeachers() {
        return this.teacherList;
    }

    public void setTeachers(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Student> getStudents() {
        return this.studentList;
    }

    public void setStudents(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Subject> getSubjects() {
        return this.subjectList;
    }

    public void setSubjects(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }
}
