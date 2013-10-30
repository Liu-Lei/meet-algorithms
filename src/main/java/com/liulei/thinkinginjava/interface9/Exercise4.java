package com.liulei.thinkinginjava.interface9;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 7/8/13
 * Time: 12:24 AM
 * To change this template use File | Settings | File Templates.
 */

abstract class AbstractFather{
    abstract void test();
}

class Son extends AbstractFather{

    public void test(){
        System.out.println("Test Method..");
    }

    public static void method(AbstractFather father){
        father.test();
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        Son son = new Son();
        Son.method(son);
    }
}
