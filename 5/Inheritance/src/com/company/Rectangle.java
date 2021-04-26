package com.company;

import java.util.ArrayList;

public class Rectangle extends Polygon{

    /**
     * Constructor
     * @param side1 side one
     * @param side2 side two
     * @param side3 side three
     * @param side4 side four
     */
    public Rectangle(double side1 , double side2 , double side3 , double side4){
        super(side1,side2,side3,side4);
    }

    /**
     *
     * @return true if Rectangle has equal super.getSides()
     */
    public boolean isSquare(){
        if(super.getSides().get(0) == super.getSides().get(1) ){
            return true;
        }
        return false;
    }

    /**
     *
     * @return perimeter of rectangle
     */
    @Override
    public double calculatePerimeter(){
        double perimeter = 0;
        for (double side: super.getSides() ){
            perimeter += side;
        }
        return perimeter;

    }

    /**
     *
     * @return area of rectangle
     */
    @Override
    public double calculateArea(){
        return super.getSides().get(0)*super.getSides().get(1);
    }

    /**
     * Draw Rectangle
     */
    @Override
    public void draw(){
        System.out.println("Rectangle -> Perimeter: " + calculatePerimeter() + " Area: " + calculateArea()  );
    }

    /**
     *
     * @param shape rectangle to check the equality
     * @return is it equal or not
     */
    @Override
    public boolean equals(Shape shape){
        if (shape instanceof Rectangle) {
            int counter = 0;
            for (double side : ((Rectangle)shape).getSides()) {
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
     * @return string that represent Rectangle
     */
    @Override
    public String toString (){
        return "Rectangle -> " + super.toString() ;
    }



}
