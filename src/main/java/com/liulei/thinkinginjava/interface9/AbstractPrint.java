package com.liulei.thinkinginjava.interface9;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 7/8/13
 * Time: 12:15 AM
 * To change this template use File | Settings | File Templates.
 */

abstract class Original{
    public Original(){
        System.out.println("Creating Original abstract class.");
    }
    abstract void print();
}

public class AbstractPrint extends Original {
    private int count = 2;
    @Override
    void print() {
        System.out.println(String.format("The count is %d.", count));
    }

    public AbstractPrint(){
        System.out.println("Creating AbstractPrint class.");
        print();
    }

    public static void main(String[] args) {
        AbstractPrint abstractPrint = new AbstractPrint();
        abstractPrint.print();
    }
}
