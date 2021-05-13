package com.company;

import java.util.ArrayList;

public class Pharmacy {
    private ArrayList<Drug> drugs;
    private ArrayList<Drug> basket;

    public Pharmacy(){
        drugs = new ArrayList<>();
        basket = new ArrayList<>();
    }
    public void addDrugToPharmacy(){}
    public void addDrugToBasket(){}
    private boolean checkDrugAvailability(){return true;}
    public ArrayList<Drug> getBasket(){return basket;}
}
