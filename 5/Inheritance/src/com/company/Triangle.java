package com.company;

import java.util.ArrayList;

public class Triangle extends Polygon{

    /**
     * Constructor
     * @param side1 side one
     * @param side2 side two
     * @param side3 side three
     */
    public Triangle(double side1 , double side2 , double side3 ){
        super(side1,side2,side3);
    }


    /**
     *
     * @return true if Triangle has equal super.getSides()
     */
    public boolean isEquilateral(){
        if(super.getSides().get(0) == super.getSides().get(1) && super.getSides().get(1) == super.getSides().get(2) ){
            return true;
        }
        return false;
    }

    /**
     *
     * @return perimeter of triangle
     */
    @Override
    public double calculatePerimeter(){
        double perimeter = 0;
        for (double side: super.getSides()) {
            perimeter += side;
        }
        return perimeter;

    }

    /**
     *
     * @return area of triangle
     */
    @Override
    public double calculateArea(){
        double s = calculatePerimeter()/2;
        return Math.sqrt(s*(s-super.getSides().get(0))*(s-super.getSides().get(1))*(s-super.getSides().get(2)));
    }

    /**
     * draw triangle
     */
    @Override
    public void draw(){
        System.out.println("Triangle -> Perimeter: " + calculatePerimeter() + " Area: " + calculateArea()  );
    }

    /**
     *
     * @param shape triangle to check the equality
     * @return is it equal or not
     */
    @Override
    public boolean equals(Shape shape){
        if (shape instanceof Triangle) {
            int counter = 0;
            for (double side : ((Triangle) shape).getSides()) {
                if (side != super.getSides().get(counter)) {
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
        return "Triangle  -> " + super.toString() ;
    }



}
