package org.globant.java.university.main;

import org.globant.java.university.execption.UniversityException;
import org.globant.java.university.model.*;
import org.globant.java.university.model.fathers.Teacher;
import org.globant.java.university.service.IUniversityService;
import org.globant.java.university.service.impl.UniversityService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        University university = new University(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        IUniversityService universityService = new UniversityService(university);
        loadTeachers(universityService);
        loadStudents(universityService);
        loadSubjects(universityService);
        mainMenu(scanner, universityService);
    }

    private static void mainMenu(Scanner scanner, IUniversityService universityService) {
        boolean exit = false;
        byte option = 0;
        while (!exit) {
            try {
                option = askAnOptionMainMenu(scanner);
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Only insert numbers");
                scanner.nextLine();
            }
            switch (option) {
                case 1:
                    printTeacherList(universityService.getTeachers());
                    System.out.println("\nPress enter to continue");
                    scanner.nextLine();
                    break;
                case 2:
                    askToPrintSubjectDataSubMenu(scanner, universityService);
                    break;
                case 3:
                    createStudent(scanner, universityService);
                    System.out.println("\nPress enter to continue\n");
                    scanner.nextLine();
                    break;
                case 4:
                    createSubject(scanner, universityService);
                    System.out.println("\nPress enter to continue\n");
                    scanner.nextLine();
                    break;
                case 5:
                    searchSubjectsByStudentId(scanner, universityService);
                    System.out.println("\nPress enter to continue\n");
                    scanner.nextLine();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Not available option");
                    System.out.println("Press enter to continue\n");
                    scanner.nextLine();
                    break;
            }
        }
    }

    private static void searchSubjectsByStudentId(Scanner scanner, IUniversityService universityService) {
        printStundentList(universityService.getStudents());
        System.out.println("\nEnter the number of the student");
        boolean isOptionCorrect = false;
        byte option = 0;
        try {
            option = scanner.nextByte();
            scanner.nextLine();
        }catch (InputMismatchException e){
            System.out.println("Only insert numbers");
            scanner.nextLine();
        }
        while (!isOptionCorrect) {
            if (option < 1 || option > universityService.getStudents().size()) {
                System.out.println("\nNot available option\n");
                System.out.println("From the above list, enter the number of the studen");
                try {
                    option = scanner.nextByte();
                    scanner.nextLine();
                }catch (InputMismatchException e){
                    System.out.println("Only insert numbers");
                    scanner.nextLine();
                }

            } else {
                List<Subject> choseSubject = universityService.getSubjectsByGivenStudent(universityService.getStudents().get(option - 1));
                System.out.println(choseSubject);
                isOptionCorrect = true;
            }
        }
    }

    private static void createSubject(Scanner scanner, IUniversityService universityService) {
        boolean isOkInsertedData = false;
        List<Student> newStudents = new ArrayList<>();
        System.out.println("Enter subjet name");
        String name = scanner.nextLine();
        System.out.println("Enter the class room");
        String classRoom = scanner.nextLine();
        printStundentList(universityService.getStudents());
        System.out.println("\nEnter the students for this subject");
        System.out.println("Just write the number with a space");
        System.out.println("For example, i choose students: 1 5 9");
        while (!isOkInsertedData) {
            try {
                String[] choseStudents = scanner.nextLine().split(" ");
                for (String position : choseStudents) {
                    newStudents.add(universityService.getStudents().get(Integer.parseInt(position) - 1));
                }
                isOkInsertedData = true;
            }catch (NumberFormatException e){
                System.out.println("Only insert numbers");
            }catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Only insert numbers in the list of students");
            }
        }
        isOkInsertedData = false;
        System.out.println("\nEnter the teacher´s id");
        printTeacherList(universityService.getTeachers());
        while (!isOkInsertedData){
            try {
                Teacher newTeacher = universityService.getTeacherById(scanner.nextInt());
                scanner.nextLine();
                Subject newSubject = new Subject(name, classRoom, newStudents, newTeacher);
                universityService.addSubjectToUniveresity(newSubject);
                System.out.println(newSubject);
                isOkInsertedData = true;
            }catch (NumberFormatException e){
                System.out.println("Only insert numbers");
                scanner.nextLine();
            } catch (UniversityException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printStundentList(List<Student> studentList) {
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println((i + 1) + ". " + studentList.get(i));
        }
    }

    private static void createStudent(Scanner scanner, IUniversityService universityService) {
        System.out.println("\nEnter student name");
        String name = scanner.nextLine();
        boolean isOkIsertedData = false;
        int age = 0;
        while (!isOkIsertedData) {
            try {
                System.out.println("Enter student age");
                age = scanner.nextInt();
                scanner.nextLine();
                isOkIsertedData = true;
            }catch (InputMismatchException e) {
                System.out.println("Only insert numbers");
                scanner.nextLine();
            }
        }
        Student student = new Student(name, age);
        universityService.addStudentToUnivesity(student);
        printSubjectList(universityService.getSubjects());
        askForSubjectToAssign(scanner, student, universityService);
    }

    private static void askForSubjectToAssign(Scanner scanner, Student student, IUniversityService universityService) {
        System.out.println("\nFrom the above list, which subject would you like to assign the student? (enter the number)\n");
        boolean isOptionCorrect = false;
        byte option = 0;
        try {
            option = scanner.nextByte();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Only insert numbers");
            scanner.nextLine();
        }
        while (!isOptionCorrect) {
            if (option < 1 || option > universityService.getSubjects().size()) {
                System.out.println("Not available option\n");
                System.out.println("From the above list, which subject would you like to assign the student? (enter the number)");
                try {
                    option = scanner.nextByte();
                    scanner.nextLine();
                } catch (InputMismatchException e) {
                    System.out.println("Only insert numbers");
                    scanner.nextLine();
                }
            } else {
                Subject choseSubject = universityService.getSubjects().get(option - 1);
                universityService.addStudentToSubject(student, choseSubject.getId());
                System.out.println(choseSubject);
                isOptionCorrect = true;
            }
        }
    }

    private static void askToPrintSubjectDataSubMenu(Scanner scanner, IUniversityService universityService) {
        boolean exit = false;
        printSubjectList(universityService.getSubjects());
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
                    System.out.println("\nNot available option");
                    break;
            }
        }
    }

    private static void printSubjectData(Scanner scanner, List<Subject> subjects) {
        printSubjectList(subjects);
        System.out.println("\nFrom the above list, which subject would you like to see? (enter the number)\n");
        boolean isOptionCorrect = false;
        byte option = scanner.nextByte();
        scanner.nextLine();
        while (!isOptionCorrect) {
            if (option >= 1 && option <= subjects.size()) {
                Subject choseSubject = subjects.get(option - 1);
                System.out.println(choseSubject);
                isOptionCorrect = true;
            } else {
                System.out.println("\nNot available option");
                printSubjectList(subjects);
                System.out.println("\nFrom the above list, which subject would you like to see? (enter the number)");
                option = scanner.nextByte();
                scanner.nextLine();
            }
        }
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
        System.out.println("6. Exit\n");

        return scanner.nextByte();
    }

    private static void loadSubjects(IUniversityService universityService) {
        Subject subject1 = new Subject("Diferential calculus", "E-205", universityService.getStudents().subList(0, 2), universityService.getTeachers().get(0));
        Subject subject2 = new Subject("OOP", "I-102", universityService.getStudents().subList(2, 4), universityService.getTeachers().get(1));
        Subject subject3 = new Subject("Vectorial calculus", "A-101", universityService.getStudents().subList(4, 6), universityService.getTeachers().get(2));
        Subject subject4 = new Subject("Integral calculus", "G-105", universityService.getStudents().subList(6, 9), universityService.getTeachers().get(3));
        universityService.addSubjectToUniveresity(subject1);
        universityService.addSubjectToUniveresity(subject2);
        universityService.addSubjectToUniveresity(subject3);
        universityService.addSubjectToUniveresity(subject4);
    }

    private static void loadStudents(IUniversityService universityService) {
        Student student1 = new Student("student1", 22);
        Student student2 = new Student("student2", 21);
        Student student3 = new Student("student3", 18);
        Student student4 = new Student("student4", 16);
        Student student5 = new Student("student5", 24);
        Student student6 = new Student("student6", 20);
        Student student7 = new Student("student7", 23);
        Student student8 = new Student("student8", 17);
        Student student9 = new Student("student9", 19);
        universityService.addStudentToUnivesity(student1);
        universityService.addStudentToUnivesity(student2);
        universityService.addStudentToUnivesity(student3);
        universityService.addStudentToUnivesity(student4);
        universityService.addStudentToUnivesity(student5);
        universityService.addStudentToUnivesity(student6);
        universityService.addStudentToUnivesity(student7);
        universityService.addStudentToUnivesity(student8);
        universityService.addStudentToUnivesity(student9);
    }

    private static void loadTeachers(IUniversityService universityService) {
        Teacher teacherFullTime1 = new FullTimeTeacher("fullTimeTeacher1", 105000, 1);
        Teacher teacherFullTime2 = new FullTimeTeacher("fullTimeTeacher2", 145000, 2);
        Teacher teacherFullTime3 = new FullTimeTeacher("fullTimeTeacher3", 127000, 3);
        Teacher teacherPartTime1 = new PartTimeTeacher("partTimeTeacher1", 112000, 1);
        Teacher teacherPartTime2 = new PartTimeTeacher("partTimeTeacher2", 171000, 2);
        Teacher teacherPartTime3 = new PartTimeTeacher("partTimeTeacher3", 155000, 3);
        universityService.addTeacherToUniversity(teacherFullTime1);
        universityService.addTeacherToUniversity(teacherFullTime2);
        universityService.addTeacherToUniversity(teacherFullTime3);
        universityService.addTeacherToUniversity(teacherPartTime1);
        universityService.addTeacherToUniversity(teacherPartTime2);
        universityService.addTeacherToUniversity(teacherPartTime3);
    }
}
