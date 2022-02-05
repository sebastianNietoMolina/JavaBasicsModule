package org.globant.java.university.service;

import org.globant.java.university.execption.UniversityException;
import org.globant.java.university.model.Student;
import org.globant.java.university.model.Subject;
import org.globant.java.university.model.fathers.Teacher;

import java.util.List;

public interface IUniversityService {

    void addTeacherToUniversity(Teacher teacher);

    void addStudentToUnivesity(Student student);

    void addSubjectToUniveresity(Subject subject);

    void addStudentToSubject(Student student, int subjectId);

    List<Teacher> getTeachers();

    List<Subject> getSubjects();

    List<Student> getStudents();

    Subject getSubjectById(int id);

    Teacher getTeacherById(int id) throws UniversityException;

    List<Subject> getSubjectsByGivenStudent(Student student);

}
