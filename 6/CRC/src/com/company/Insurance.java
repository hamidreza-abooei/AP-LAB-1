package com.company;

public class Insurance {
    private String name;
    private InsuranceLevel insuranceLevel;
    public Insurance(String name , InsuranceLevel insuranceLevel){
        this.name = name;
        this.insuranceLevel = insuranceLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InsuranceLevel getInsuranceLevel() {
        return insuranceLevel;
    }

    public void setInsuranceLevel(InsuranceLevel insuranceLevel) {
        this.insuranceLevel = insuranceLevel;
    }
}
