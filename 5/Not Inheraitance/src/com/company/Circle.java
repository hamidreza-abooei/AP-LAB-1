package com.company;

import java.util.ArrayList;

public class Circle {
    private double radius;

    /**
     * constructor
     * @param radius the radius of circle
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     *
     * @return Radius of circle
     */
    public double getRadius() {
        return radius;
    }


    /**
     *
     * @return perimeter of Circle
     */
    public double calculatePerimeter(){
        return 2 * Math.PI * radius;
    }

    /**
     *
     * @return area of Circle
     */
    public double calculateArea(){
        return Math.PI * radius * radius;
    }

    /**
     * Draw Circle
     */
    public void draw(){
        System.out.println("Circle -> Perimeter: " + calculatePerimeter() + " Area: " + calculateArea()  );
    }

    /**
     *
     * @param circle rectangle to check the equality
     * @return is it equal or not
     */
    public boolean equals(Object circle){
        if (circle instanceof Circle) {
            return (((Circle)circle).getRadius() == this.getRadius());
        }
        return false;
    }

    /**
     *
     * @return string that represent Circle
     */
    @Override
    public String toString (){
        return "Circle -> sides: " + radius;
    }
}
