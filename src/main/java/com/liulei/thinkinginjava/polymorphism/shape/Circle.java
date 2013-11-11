//: polymorphism/shape/Circle.java
package com.liulei.thinkinginjava.polymorphism.shape;

public class Circle extends Shape {
    @Override
    public void draw() {
        System.out.println("Circle.draw()");
    }

    public void erase() {
        System.out.println("Circle.erase()");
    }

    @Override
    public void reDraw() {
        System.out.println("Circle redraw.");
    }
} ///:~
