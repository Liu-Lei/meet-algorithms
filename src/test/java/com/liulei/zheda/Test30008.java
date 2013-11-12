package com.liulei.zheda;

/**
 * Created with IntelliJ IDEA.
 * User: liulei
 * Date: 13-11-5
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */

import java.text.DecimalFormat;
import java.util.Scanner;
public class Test30008{
    public static void main(String args[]){
        int repeat, ri,x;
        double y;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        DecimalFormat df=new DecimalFormat("#.##");
        for(ri = 1; ri <= repeat; ri++){
            x=in.nextInt();
    		if(x == 0){
                y = 0.0;
                System.out.println("f("+x+")="+y);
            }else{
                y = 1 / (double)x;
                System.out.println("f("+x+")="+df.format(y));
            }

        }
    }
}