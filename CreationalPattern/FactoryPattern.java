package FactoryPattern;

import java.awt.*;
import java.util.Objects;
import java.util.Scanner;

public class FactoryPattern {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Please give me the number of lines");
        int numberOfSide = sc.nextInt();

        ShapeFactory shapeFactory = new ShapeFactory();
        Shape shape = shapeFactory.getShape(numberOfSide);

        if(Objects.isNull(shape)) {
            System.out.println("No shape found");
        } else {
            shape.draw();
        }
    }
}

class ShapeFactory {

    public Shape getShape(int numberOfSide) {

        return switch (numberOfSide) {
            case 3 -> new Triangle();
            case 4 -> new Square();
            case 0 -> new Circle();
            default -> null;
        };
    }
}

interface Shape {

    void draw();
}

class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Triangle shape");
    }
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Circle shape");
    }
}

class Square implements Shape {

    @Override
    public void draw() {
        System.out.println("Square shape");
    }
}

