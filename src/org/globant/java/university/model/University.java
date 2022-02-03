package org.globant.java.university.model;

import org.globant.java.university.model.fathers.Teacher;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class University {

    private List<Teacher> teacherList;
    private List<Student> studentList;
    private List<Subject> subjectList;

    public University(List<Teacher> teacherList, List<Student> studentList, List<Subject> subjectList) {
        this.teacherList = teacherList;
        this.studentList = studentList;
        this.subjectList = subjectList;
    }

    public void addTeacher(Teacher teacher) {
        List<Teacher> newTeacherList = new ArrayList<>();
        newTeacherList.addAll(teacherList);
        newTeacherList.add(teacher);
        setTeachers(newTeacherList);
    }

    public void addStudent(Student student) {
        List<Student> newStudentList = new ArrayList<>();
        newStudentList.addAll(studentList);
        newStudentList.add(student);
        setStudents(newStudentList);
    }

    public void addSubject(Subject subject) {
        List<Subject> newSubjectList = new ArrayList<>();
        newSubjectList.addAll(subjectList);
        newSubjectList.add(subject);
        setSubjects(newSubjectList);
    }

    public void addStudentToSubject(Student student, int subjectId) {
        for (int i = 0; i < subjectList.size(); i++) {
            if (subjectList.get(i).getId() == subjectId) {
                subjectList.get(i).addStudent(student);
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
