package com.company;

import java.util.ArrayList;

public class Triangle {
    private ArrayList<Double> sides;

    /**
     * Constructor
     * @param side1 side one
     * @param side2 side two
     * @param side3 side three
     */
    public Triangle(double side1 , double side2 , double side3 ){
        sides = new ArrayList<>();
        sides.add(side1);
        sides.add(side2);
        sides.add(side3);
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
     * @return true if Triangle has equal sides
     */
    public boolean isEquilateral(){
        if(sides.get(0) == sides.get(1) && sides.get(1) == sides.get(2) ){
            return true;
        }
        return false;
    }

    /**
     *
     * @return perimeter of triangle
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
     * @return area of triangle
     */
    public double calculateArea(){
        double s = calculatePerimeter()/2;
        return Math.sqrt(s*(s-sides.get(0))*(s-sides.get(1))*(s-sides.get(2)));
    }

    /**
     * draw triangle
     */
    public void draw(){
        System.out.println("Triangle -> Perimeter: " + calculatePerimeter() + " Area: " + calculateArea()  );
    }

    /**
     *
     * @param triangle triangle to check the equality
     * @return is it equal or not
     */
    public boolean equals(Object triangle){
        if (triangle instanceof Triangle) {
            int counter = 0;
            for (double side : ((Triangle)triangle).getSides()) {
                if (side != sides.get(counter)) {
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
     * @return string that represent triangle
     */
    @Override
    public String toString (){
        return "Triangle -> sides: " + sides;
    }



}
