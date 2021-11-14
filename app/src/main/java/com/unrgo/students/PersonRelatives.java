package com.unrgo.students;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

public class PersonRelatives {
    private String fullName;
    private String typeRelative;
    private boolean isLiveTogether;
    private int id;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public PersonRelatives(String fullName, String typeRelative, boolean isLiveTogether) {
        this.fullName = fullName;
        this.isLiveTogether = isLiveTogether;
        this.typeRelative = typeRelative;

    }

    public PersonRelatives(String fullName, String typeRelative,boolean isLiveTogether, int id) {
      this(fullName,typeRelative,isLiveTogether);
      this.id = id;
    }


    private static final ArrayList<PersonRelatives> relatives = new ArrayList<PersonRelatives>(
            Arrays.asList(
                    new PersonRelatives("Dychko","Mother",true),
                    new PersonRelatives("Jobs","Father",true),
                    new PersonRelatives("Smith","Sister",true),
                    new PersonRelatives("Nakonechiniy","Brother",false)
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
        return this.fullName;
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

    public boolean isLiveTogether() {
        return isLiveTogether;
    }

    public void setLiveTogether(boolean liveTogether) {
        isLiveTogether = liveTogether;
    }
}
