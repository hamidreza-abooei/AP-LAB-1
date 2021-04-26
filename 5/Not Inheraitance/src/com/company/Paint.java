package com.company;

import java.util.ArrayList;

public class Paint {
    private ArrayList<Triangle> triangles;
    private ArrayList<Circle> circles;
    private ArrayList<Rectangle> rectangles;


    public Paint(){
        triangles = new ArrayList<>();
        circles = new ArrayList<>();
        rectangles = new ArrayList<>();
    }

    public void addTriangle(Triangle triangle){
        triangles.add(triangle);
    }
    public void addCircle(Circle circle){
        circles.add(circle);
    }
    public void addRectangle(Rectangle rectangle){
        rectangles.add(rectangle);
    }
    public void drawAll(){
        for (Triangle triangle: triangles){
            triangle.draw();
        }
        for (Rectangle rectangle: rectangles){
            rectangle.draw();
        }
        for (Circle circle: circles){
            circle.draw();
        }

    }
    public void printAll(){
        for (Triangle triangle: triangles){
            System.out.println(triangle.toString());
        }
        for (Rectangle rectangle: rectangles){
            System.out.println(rectangle.toString());
        }
        for (Circle circle: circles){
            System.out.println(circle.toString());
        }
    }
}
