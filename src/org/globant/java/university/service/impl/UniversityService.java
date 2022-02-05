package org.globant.java.university.service.impl;

import org.globant.java.university.execption.UniversityException;
import org.globant.java.university.model.Student;
import org.globant.java.university.model.Subject;
import org.globant.java.university.model.University;
import org.globant.java.university.model.fathers.Teacher;
import org.globant.java.university.service.IUniversityService;

import java.util.List;

public class UniversityService implements IUniversityService {

    private University university;

    public UniversityService(University university) {
        this.university = university;
    }

    public University getUniversity() {
        return university;
    }

    public void setUniversity(University university) {
        this.university = university;
    }

    @Override
    public void addTeacherToUniversity(Teacher teacher) {
        this.university.addTeacher(teacher);
    }

    @Override
    public void addStudentToUnivesity(Student student) {
        this.university.addStudent(student);
    }

    @Override
    public void addSubjectToUniveresity(Subject subject) {
        this.university.addSubject(subject);
    }

    @Override
    public void addStudentToSubject(Student student, int subjectId) {
        this.university.addStudentToSubject(student, subjectId);
    }

    @Override
    public List<Teacher> getTeachers() {
        return this.university.getTeachers();
    }

    @Override
    public List<Subject> getSubjects() {
        return this.university.getSubjects();
    }

    @Override
    public List<Student> getStudents() {
        return this.university.getStudents();
    }

    @Override
    public Subject getSubjectById(int subjectId) {
        return this.university.getSubjectById(subjectId);
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws UniversityException {
        return this.university.getTeacherById(teacherId);
    }

    @Override
    public List<Subject> getSubjectsByGivenStudent(Student student) {
        return this.university.getSubjectsByGivenStudent(student);
    }
}
