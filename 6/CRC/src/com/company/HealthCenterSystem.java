package com.company;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;

public class HealthCenterSystem {
    private ArrayList<University> universities;
    private ArrayList<Patient> patients;
    private ArrayList<HealthHistory> healthHistories;
    private ArrayList<Doctor> doctors;
    private ArrayList<Insurance> insurances;
    private ArrayList<Pharmacy> pharmacies;

    public HealthCenterSystem(){
        universities = new ArrayList<>();
        patients = new ArrayList<>();
        healthHistories = new ArrayList<>();
        doctors = new ArrayList<>();
        insurances = new ArrayList<>();
        pharmacies = new ArrayList<>();

    }

    private boolean CheckUniversityAccess(){return true;}
    private boolean CheckDoctorAccess(){return true;}
    public void changePatientHealthHistory(){};
    public void getPatientDetailsByUniversities(){};
    public void addDoctor(){}
    public void addPatient(){}
    public void addUniversity(){}
    public void addInsurance(){}
    public void getDoctor(){}
    public void getPatient(){}
    public void getInsurance(){}
    public void setPatientInsurance(){}
    public void addPatientDoctor(){}
    public void addPharmacy(){}


}
