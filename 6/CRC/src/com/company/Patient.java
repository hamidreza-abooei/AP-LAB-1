package com.company;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class Patient {
    private String name;
    private Date birthDate;
    private Location location;
    private Gender gender;
    private Insurance insurance;
    private Insurance secondaryInsurance;
    private Degree degree;
    private String Job;
    private HealthHistory healthHistory;
    private HashMap<Doctor,String> doctors;//doctors with their access

    public Patient(String name, Date birthDate,
                   Location location, Gender gender,
                   Insurance insurance, Insurance secondaryInsurance,
                   Degree degree, String job,
                   HealthHistory healthHistory,
                   Doctor doctor) {
        this.name = name;
        this.birthDate = birthDate;
        this.location = location;
        this.gender = gender;
        this.insurance = insurance;
        this.secondaryInsurance = secondaryInsurance;
        this.degree = degree;
        Job = job;
        this.healthHistory = healthHistory;
        this.doctors = new HashMap<>();
        doctors.put(doctor,"FullAccess");
    }

    public void addDoctor(Doctor doctor,String access){}
    public void removeDoctor(Doctor doctor){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Insurance getInsurance() {
        return insurance;
    }

    public void setInsurance(Insurance insurance) {
        this.insurance = insurance;
    }

    public Insurance getSecondaryInsurance() {
        return secondaryInsurance;
    }

    public void setSecondaryInsurance(Insurance secondaryInsurance) {
        this.secondaryInsurance = secondaryInsurance;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getJob() {
        return Job;
    }

    public void setJob(String job) {
        Job = job;
    }

    public HealthHistory getHealthHistory() {
        return healthHistory;
    }

    public void setHealthHistory(HealthHistory healthHistory) {
        this.healthHistory = healthHistory;
    }
}
