package com.unrgo.students;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private final String name;
    private final String groupNumber;

    public Student(String name, String groupNumber) {
        this.name = name;
        this.groupNumber = groupNumber;

    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public String getName() {
        return name;
    }

    private final static ArrayList<Student> students = new ArrayList<Student>(
            Arrays.asList(
                    new Student("Sergey Dychko","301"),
                    new Student("Simple Dimple","301"),
                    new Student("Vlad Klencar","302"),
                    new Student("Dima Krawa","302"),
                    new Student("Alexandra Bardizh","303"),
                    new Student("Max Zdrazhevskiy","303"),
                    new Student("Denys Menshow","304")
                    )
            );

    public static ArrayList<Student> getStudents (String groupNumber){
        ArrayList<Student> studentsList = new ArrayList<>();
        for (Student s: students){
            if(s.getGroupNumber().equals(groupNumber)){
                studentsList.add(s);
            }
        }
        return  studentsList;
    }
}
