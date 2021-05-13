package com.company;

public class Disease {
    private String name;
    private DiseaseType diseaseType;
    private ImmunityLevel immunityLevel;
    public Disease(String name,
                   DiseaseType diseaseType,
                   ImmunityLevel immunityLevel){
        this.name = name;
        this.diseaseType = diseaseType;
        this.immunityLevel = immunityLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiseaseType getDiseaseType() {
        return diseaseType;
    }

    public ImmunityLevel getImmunityLevel() {
        return immunityLevel;
    }
}
