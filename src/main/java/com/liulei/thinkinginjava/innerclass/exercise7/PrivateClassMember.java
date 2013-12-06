package com.liulei.thinkinginjava.innerclass.exercise7;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 11/26/13
 * Time: 11:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrivateClassMember {
    private String str = "1";
    private void getString(){
        System.out.println("PrivateClassMember");
    }

    class InnerClass{
        void innerMethod(){
            PrivateClassMember.this.str = "2";
            getString();

        }
    }

    private void method2(){
        InnerClass innerClass = new InnerClass();
        innerClass.innerMethod();
    }

    String getStr(){
        return str;
    }

    public static void main(String[] args) {
        PrivateClassMember classMember = new PrivateClassMember();
        classMember.method2();
        System.out.println(classMember.getStr());
    }

}
