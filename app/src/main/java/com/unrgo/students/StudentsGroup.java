package com.unrgo.students;

import java.util.ArrayList;
import java.util.Arrays;

public class StudentsGroup {
    private String number;
    private String facultyName;
    private int educationLevel;
    private boolean contractExistsFlag;
    private boolean privilageExistsFlag;

    public StudentsGroup(String number, String facultyName, int educationLevel, boolean contractExistsFlag, boolean privilageExistsFlag) {
        this.number = number;
        this.facultyName = facultyName;
        this.educationLevel = educationLevel;
        this.contractExistsFlag = contractExistsFlag;
        this.privilageExistsFlag = privilageExistsFlag;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public int getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(int educationLevel) {
        this.educationLevel = educationLevel;
    }

    public boolean isContractExistsFlag() {
        return contractExistsFlag;
    }

    public void setContractExistsFlag(boolean contractExistsFlag) {
        this.contractExistsFlag = contractExistsFlag;
    }

    public boolean isPrivilageExistsFlag() {
        return privilageExistsFlag;
    }

    public void setPrivilageExistsFlag(boolean privilageExistsFlag) {
        this.privilageExistsFlag = privilageExistsFlag;
    }

    private final static ArrayList<StudentsGroup> groups = new ArrayList<StudentsGroup>(
            Arrays.asList(
                    new StudentsGroup("301","Computer Science",0,true,false),
                    new StudentsGroup("302","Computer Science",0,true,false),
                    new StudentsGroup("305","Computer Science",0,true,true),
                    new StudentsGroup("309","Computer Science",0,true,false),
                    new StudentsGroup("309g","Computer Science",0,true,false)
            )
    );

    public static StudentsGroup getGroup(String groupNumber){
        for(StudentsGroup g:groups){
            if(g.getNumber().equals(groupNumber)){
                return g;
            }
        }
        return null;
    }

}
