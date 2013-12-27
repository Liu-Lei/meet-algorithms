package com.liulei.zheda;

/**
 * Created with IntelliJ IDEA.
 * User: liulei
 * Date: 13-11-5
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */

import java.io.IOException;

import java.util.Scanner;

public class Test30003 {
    public static void main(String[] args){
        int ri, repeat;
        float a, b, c, area, perimeter, s;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            a=in.nextFloat();
            b=in.nextFloat();
            c=in.nextFloat();
            area = perimeter = 0;
            if(a+b>c && a+c>b && b+c>a){
                s = (a+b+c)/2;
                area = (float)Math.sqrt(s*(s-a)*(s-b)*(s-c));
                perimeter = a+b+c;
                System.out.println("area="+(int)(area*100+0.5)/100.+";perimeter="+(int)(perimeter*100+0.5)/100.);
            }else{
                System.out.println("These sides do not correspond to a valid triangle");
            }
        }
    }
}