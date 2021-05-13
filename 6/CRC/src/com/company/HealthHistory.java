package com.company;

import java.util.Date;

public class HealthHistory {
    private DiseaseType diseaseType;
    private String healthCondition;
    private String doctorRecognition;
    private ImmunityLevel immunityLevel;
    private Date date;
    private Doctor doctor;

    public HealthHistory(DiseaseType diseaseType,
                         String healthCondition,
                         String doctorRecognition,
                         ImmunityLevel immunityLevel,
                         Date date, Doctor doctor) {
        this.diseaseType = diseaseType;
        this.healthCondition = healthCondition;
        this.doctorRecognition = doctorRecognition;
        this.immunityLevel = immunityLevel;
        this.date = date;
        this.doctor = doctor;
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(DiseaseType diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(String healthCondition) {
        this.healthCondition = healthCondition;
    }

    public String getDoctorRecognition() {
        return doctorRecognition;
    }

    public void setDoctorRecognition(String doctorRecognition) {
        this.doctorRecognition = doctorRecognition;
    }

    public ImmunityLevel getImmunityLevel() {
        return immunityLevel;
    }

    public void setImmunityLevel(ImmunityLevel immunityLevel) {
        this.immunityLevel = immunityLevel;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
