package com.company;

public class University {
    private String universityName;
    private String accessLevel;
    public University(String universityName){
        this.accessLevel = null;
        this.universityName = universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(String accessLevel) {
        this.accessLevel = accessLevel;
    }
    public void research(){}
}
