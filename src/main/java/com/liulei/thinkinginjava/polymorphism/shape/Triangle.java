//: polymorphism/shape/Triangle.java
package com.liulei.thinkinginjava.polymorphism.shape;

public class Triangle extends Shape {
    @Override
    public void draw() {
        System.out.println("Triangle.draw()");
    }

    @Override
    public void erase() {
        System.out.println("Triangle.erase()");
    }

    public void reDraw(){
        System.out.println("Triangle redraw.");
    }
} ///:~
