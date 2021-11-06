package com.unrgo.students;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class PersonRelatives {
    private String fullName;
    private String typeRelative;
    private int age;
    private boolean isLiveTogether;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonRelatives(String fullName, String typeRelative, int age, boolean isLiveTogether) {
        this.age = age;
        this.fullName = fullName;
        this.isLiveTogether = isLiveTogether;
        this.typeRelative = typeRelative;

    }

    public PersonRelatives(String fullName, String typeRelative, int age, boolean isLiveTogether, int id) {
      this(fullName,typeRelative,age,isLiveTogether);
      this.id = id;
    }




    private static ArrayList<PersonRelatives> relatives = new ArrayList<PersonRelatives>(
            Arrays.asList(
                    new PersonRelatives("Swetlana Dychko","Mother",44,true),
                    new PersonRelatives("Anatoliy Dychko","Father",51,true),
                    new PersonRelatives("Ksenia Dychko","Sister",25,true),
                    new PersonRelatives("Vladimir Nakonechiniy","Brother",16,false)
            )
    );

    public static void addRelative(PersonRelatives relative){
        relatives.add(relative);
    }

    public static PersonRelatives getRelative(String fullName){
        for(PersonRelatives r:relatives){
            if(r.getFullName().equals(fullName)){
                return r;
            }
        }
        return null;
    }

    public static ArrayList<PersonRelatives> getRelatives(){
        return relatives;
    }

    @NonNull
    @Override
    public String toString(){
        return fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTypeRelative() {
        return typeRelative;
    }

    public void setTypeRelative(String typeRelative) {
        this.typeRelative = typeRelative;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isLiveTogether() {
        return isLiveTogether;
    }

    public void setLiveTogether(boolean liveTogether) {
        isLiveTogether = liveTogether;
    }
}
