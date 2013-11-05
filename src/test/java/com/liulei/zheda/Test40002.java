package com.liulei.zheda;

/**
 * Created with IntelliJ IDEA.
 * User: liulei
 * Date: 13-11-5
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */

import java.util.Scanner;
public class Test40002 {
    public static void main(String[] args) {
        int ri, repeat;
        int i, n;
        double fact;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            n=in.nextInt();
            fact = 1.0;
		    for(i=1; i <= n; i++){
                fact *= i;
            }
            System.out.println(fact);
        }
    }
}