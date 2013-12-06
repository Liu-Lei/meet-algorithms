package com.liulei.thinkinginjava.innerclass.exercise6.inner2;

import com.liulei.thinkinginjava.innerclass.exercise6.OuterPackageInterface;
import com.liulei.thinkinginjava.innerclass.exercise6.inner.InnerClass;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 11/26/13
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Inner2Class extends InnerClass {
    OuterPackageInterface aMethod(){
        return this.new ImplementsInner();
    }

    public static void main(String[] args) {
        Inner2Class inner2Class = new Inner2Class();
        inner2Class.aMethod().name();
    }
}
