package com.unrgo.students;

import java.util.ArrayList;
import java.util.Arrays;

public class Person {
    private final String name;
    private final int age;
    private int relative_id;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;

    }

    public Person(String name,int age,int relative_id){
        this(name,age);
        this.relative_id = relative_id;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    private final static ArrayList<Person> persons = new ArrayList<Person>(
            Arrays.asList(
                    new Person("Sergey Dychko",14),
                    new Person("Simple Dimple",18),
                    new Person("Vlad Klencar",21),
                    new Person("Dima Krawa",12),
                    new Person("Alexandra Bardizh",19),
                    new Person("Max Zdrazhevskiy",20)
                    )
            );

    static ArrayList<Person> getPersons(){
        return getPersons("");
    }

    public static ArrayList<Person> getPersons (String personName){
        ArrayList<Person> personsList = new ArrayList<>();
        for (Person s: persons){
            if(s.getName().equals(personName) || personName.equals("")){
                personsList.add(s);
            }
        }
        return  personsList;
    }

    public int getRelative_id() {
        return relative_id;
    }

    public void setRelative_id(int relative_id) {
        this.relative_id = relative_id;
    }
}
