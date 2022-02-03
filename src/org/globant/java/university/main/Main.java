package org.globant.java.university.main;

import org.globant.java.university.model.*;
import org.globant.java.university.model.fathers.Teacher;
import org.globant.java.university.service.IUniversityService;
import org.globant.java.university.service.impl.UniversityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Teacher> teacherList = loadTeachers();
        List<Student> studentList = loadStudents();
        List<Subject> subjectList = loadSubjects(teacherList, studentList);

        University university = new University(teacherList, studentList, subjectList);
        IUniversityService universityService = new UniversityService(university);

        mainMenu(scanner, universityService);
    }

    private static void mainMenu(Scanner scanner, IUniversityService universityService) {
        boolean exit = false;
        while (!exit) {
            byte option = askAnOptionMainMenu(scanner);
            switch (option) {
                case 1:
                    printTeacherList(universityService.getTeachers());
                    scanner.nextLine();
                    break;
                case 2:
                    askToPrintSubjectDataSubMenu(scanner, universityService);
                    scanner.nextLine();
                    break;
                case 3:
                    createStudent(scanner, universityService);
                    scanner.nextLine();
                    break;
                case 4:
                    createSubject(scanner, universityService);
                    scanner.nextLine();
                    break;
                case 5:
                    searchSubjectsByStudentId(scanner, universityService);
                    scanner.nextLine();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Not available option\n");
                    break;
            }
        }
    }

    private static void searchSubjectsByStudentId(Scanner scanner, IUniversityService universityService) {
        printStundentList(universityService.getStudents());
        System.out.println("Enter the number of the student");
        byte option = scanner.nextByte();
        do {
            if (option < 1 || option > universityService.getStudents().size()) {
                System.out.println("Not available option\n");
                System.out.println("From the above list, enter the number of the studen");
                option = scanner.nextByte();
            } else {
                List<Subject> choseSubject = universityService.getSubjectsByGivenStudent(universityService.getStudents().get(option-1));
                System.out.println(choseSubject);
            }
        } while (option < 1 || option > universityService.getStudents().size());

    }

    private static void createSubject(Scanner scanner, IUniversityService universityService) {
        List<Student> newStudents = new ArrayList<>();
        System.out.println("Enter a name");
        String name = scanner.next();
        System.out.println("Enter the class room");
        String classRoom = scanner.next();

        printStundentList(universityService.getStudents());
        System.out.println("Enter the students for this subject");
        System.out.println("Just write the number with a space");
        System.out.println("For example, i choose students: 1 5 9");
        String[] choseStudents = scanner.next().split(" ");

        for (String position: choseStudents) {
            newStudents.add(universityService.getStudents().get(Integer.parseInt(position)-1));
        }

        System.out.println("\nEnter the teacher´s id");
        printTeacherList(universityService.getTeachers());
        Teacher newTeacher = universityService.getTeacherById(scanner.nextInt());

        Subject newSubject = new Subject(name, classRoom, newStudents, newTeacher);
        universityService.addSubjectToUniveresity(newSubject);
    }

    private static void printStundentList(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + "." + studentList.get(i));
        }
    }

    private static void createStudent(Scanner scanner, IUniversityService universityService) {
        System.out.println("Enter a name");
        String name = scanner.next();
        System.out.println("Enter an age");
        int age = scanner.nextInt();

        Student student = new Student(name, age);
        universityService.addStudentToUnivesity(student);

        printSubjectList(universityService.getSubjects());
        askForSubjectToAssign(scanner, student, universityService);
    }

    private static void askForSubjectToAssign(Scanner scanner, Student student, IUniversityService universityService) {
        System.out.println("\nFrom the above list, which subject would you like to assign the student? (enter the number)");
        byte option = scanner.nextByte();
        scanner.nextLine();
        do {
            if (option < 1 || option > universityService.getSubjects().size()) {
                System.out.println("Not available option\n");
                System.out.println("From the above list, which subject would you like to assign the student? (enter the number)");
                option = scanner.nextByte();
                scanner.nextLine();
            } else {
                scanner.nextLine();
                Subject choseSubject = universityService.getSubjects().get(option - 1);
                universityService.addStudentToSubject(student,choseSubject.getId());
                System.out.println(choseSubject);
            }
        } while (option < 1 || option > universityService.getSubjects().size());
    }

    private static void askToPrintSubjectDataSubMenu(Scanner scanner, IUniversityService universityService) {
        boolean exit = false;
        printSubjectList(universityService.getSubjects());
        scanner.nextLine();
        while (!exit) {
            byte option = askAnOptionSubMenuSubjectData(scanner);
            scanner.nextLine();
            switch (option) {
                case 1:
                    printSubjectData(scanner, universityService.getSubjects());
                    break;
                case 2:
                    exit = true;
                    break;
                default:
                    System.out.println("Not available option");
                    break;
            }
        }
    }

    private static void printSubjectData(Scanner scanner, List<Subject> subjects) {
        printSubjectList(subjects);
        System.out.println("\nFrom the above list, which subject would you like to see? (enter the number)");
        byte option = scanner.nextByte();
        scanner.nextLine();
        do {
            if (option >= 1 && option <= subjects.size()) {
                System.out.println(option);
                Subject choseSubject = subjects.get(option - 1);
                System.out.println(choseSubject);
            } else {
                System.out.println("Not available option\n");
                printSubjectList(subjects);
                System.out.println("\nFrom the above list, which subject would you like to see? (enter the number)");
                option = scanner.nextByte();
                scanner.nextLine();
            }
        } while (option < 1 || option > subjects.size());
    }

    private static byte askAnOptionSubMenuSubjectData(Scanner scanner) {
        System.out.println("\nWhat would you like to do? \n");
        System.out.println("1. Show specific subject data like teachers and student");
        System.out.println("2. Back to main menu");

        return scanner.nextByte();
    }

    private static void printSubjectList(List<Subject> subjectList) {
        for (int i = 0; i < subjectList.size(); i++) {
            System.out.println((i + 1) + ". " + subjectList.get(i).getName());
        }
    }

    private static void printTeacherList(List<Teacher> teacherList) {
        for (Teacher teacher : teacherList) {
            System.out.println(teacher);
        }
    }

    private static byte askAnOptionMainMenu(Scanner scanner) {
        System.out.println("\nGood day!!");
        System.out.println("Which option will you choose today? \n");
        System.out.println("1. Show teachers");
        System.out.println("2. Show subjects");
        System.out.println("3. Create a new student");
        System.out.println("4. Create a new subject");
        System.out.println("5. Search subjects by student");
        System.out.println("6. Exit");

        return scanner.nextByte();
    }

    private static List<Subject> loadSubjects(List<Teacher> teacherList, List<Student> studentList) {
        List<Subject> subjectList = new ArrayList<>();

        Subject subject1 = new Subject("Diferential calculus", "E-205", studentList.subList(0, 2), teacherList.get(0));
        Subject subject2 = new Subject("OOP", "I-102", studentList.subList(2, 4), teacherList.get(1));
        Subject subject3 = new Subject("Vectorial calculus", "A-101", studentList.subList(4, 6), teacherList.get(2));
        Subject subject4 = new Subject("Integral calculus", "G-105", studentList.subList(6, 9), teacherList.get(3));

        subjectList.add(subject1);
        subjectList.add(subject2);
        subjectList.add(subject3);
        subjectList.add(subject4);

        return subjectList;
    }

    private static List<Student> loadStudents() {
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student("student1", 22);
        Student student2 = new Student("student2", 21);
        Student student3 = new Student("student3", 18);
        Student student4 = new Student("student4", 16);
        Student student5 = new Student("student5", 24);
        Student student6 = new Student("student6", 20);
        Student student7 = new Student("student7", 23);
        Student student8 = new Student("student8", 17);
        Student student9 = new Student("student9", 19);

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
        studentList.add(student8);
        studentList.add(student9);

        return studentList;
    }

    private static List<Teacher> loadTeachers() {
        List<Teacher> teacherList = new ArrayList<>();

        Teacher teacherFullTime1 = new FullTimeTeacher("fullTimeTeacher1", 105000, 1);
        Teacher teacherFullTime2 = new FullTimeTeacher("fullTimeTeacher2", 145000, 2);
        Teacher teacherFullTime3 = new FullTimeTeacher("fullTimeTeacher3", 127000, 3);

        Teacher teacherPartTime1 = new PartTimeTeacher("partTimeTeacher1", 112000, 1);
        Teacher teacherPartTime2 = new PartTimeTeacher("partTimeTeacher2", 171000, 2);
        Teacher teacherPartTime3 = new PartTimeTeacher("partTimeTeacher3", 155000, 3);

        teacherList.add(teacherFullTime1);
        teacherList.add(teacherFullTime2);
        teacherList.add(teacherFullTime3);
        teacherList.add(teacherPartTime1);
        teacherList.add(teacherPartTime2);
        teacherList.add(teacherPartTime3);

        return teacherList;
    }
}
