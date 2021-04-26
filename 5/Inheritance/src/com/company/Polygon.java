package com.company;

import java.util.ArrayList;
import java.util.function.DoubleUnaryOperator;

public class Polygon extends Shape{
    private ArrayList<Double> sides;

    public Polygon(double... sides) {
        this.sides = new ArrayList<>();
        for (double side : sides) {
            this.sides.add(side);
        }
    }
    @Override
    public String toString(){
        String string = "";
        int counter = 0;
        for (Double side:sides){
            counter++;
            string += "side" + counter + ":" + side + "   ";
        }
        return string;
    }

    /**
     * return sides
     * @return array list of sides
     */
    public ArrayList<Double> getSides (){
        return sides;
    }


}
