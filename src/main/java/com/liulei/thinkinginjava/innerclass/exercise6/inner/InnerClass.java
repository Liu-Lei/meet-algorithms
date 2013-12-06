package com.liulei.thinkinginjava.innerclass.exercise6.inner;

import com.liulei.thinkinginjava.innerclass.exercise6.OuterPackageInterface;

/**
 * Created with IntelliJ IDEA.
 * User: Leo
 * Date: 11/26/13
 * Time: 10:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class InnerClass {
    protected class ImplementsInner implements OuterPackageInterface{
        public ImplementsInner(){}
        @Override
        public void name() {
            System.out.println("ImplementsInner");
        }
    }
}
