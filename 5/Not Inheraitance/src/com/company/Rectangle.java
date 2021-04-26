package com.company;

import java.util.ArrayList;

public class Rectangle {
    private ArrayList<Double> sides;

    /**
     * Constructor
     * @param side1 side one
     * @param side2 side two
     * @param side3 side three
     * @param side4 side four
     */
    public Rectangle(double side1 , double side2 , double side3 , double side4){
        sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
        sides.add(side4);
    }

    /**
     * return sides
     * @return array list of sides
     */
    public ArrayList<Double> getSides() {
        return sides;
    }

    /**
     *
     * @return true if Rectangle has equal sides
     */
    public boolean isSquare(){
        if(sides.get(0) == sides.get(1) && sides.get(1) == sides.get(2) && sides.get(2) == sides.get(3)){
            return true;
        }
        return false;
    }

    /**
     *
     * @return perimeter of rectangle
     */
    public double calculatePerimeter(){
        double perimeter = 0;
        for (double side: sides) {
            perimeter += side;
        }
        return perimeter;

    }

    /**
     *
     * @return area of rectangle
     */
    public double calculateArea(){
        return sides.get(0)*sides.get(1);
    }

    /**
     * Draw Rectangle
     */
    public void draw(){
        System.out.println("Rectangle -> Perimeter: " + calculatePerimeter() + " Area: " + calculateArea()  );
    }

    /**
     *
     * @param rectangle rectangle to check the equality
     * @return is it equal or not
     */
    public boolean equals(Object rectangle){
        if (rectangle instanceof Rectangle){
            int counter = 0;
            for (double side: ((Rectangle)rectangle).getSides()) {
                if (side != sides.get(counter)){
                    return false;
                }
                counter++;
            }
            return true;
        }
        return false;
    }

    /**
     *
     * @return string that represent Rectangle
     */
    @Override
    public String toString (){
        return "Rectangle -> sides: " + sides;
    }



}
