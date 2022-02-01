package org.globant.java.university.main;

import org.globant.java.university.model.FullTimeTeacher;
import org.globant.java.university.model.PartTimeTeacher;
import org.globant.java.university.model.ext.Teacher;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Teacher> teachers = new ArrayList<>();
        Teacher teacherFullTime1 = new FullTimeTeacher("ome1", 145000,1);
        Teacher teacherFullTime2 = new FullTimeTeacher("ome2", 145000,1);
        Teacher teacherFullTime3 = new FullTimeTeacher("ome3", 145000,1);

        Teacher teacherPartTime1 = new PartTimeTeacher("part1", 145000, 3);
        Teacher teacherPartTime2 = new PartTimeTeacher("part2", 145000, 3);
        Teacher teacherPartTime3 = new PartTimeTeacher("part3", 145000, 3);

        teachers.add(teacherFullTime1);
        teachers.add(teacherFullTime2);
        teachers.add(teacherFullTime3);
        teachers.add(teacherPartTime1);
        teachers.add(teacherPartTime2);
        teachers.add(teacherPartTime3);

    }
}
