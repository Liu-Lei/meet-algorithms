package com.liulei.zheda;

import java.util.Scanner;
public class Test30005 {
    public static void main(String[] args){
        int ri, repeat;
        float rate, salary, tax;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            salary=in.nextFloat();
            if(salary <= 850){
                rate = 0;
            }else if( salary > 850 && salary <= 1350){
                rate = 0.05f;
            }else if( salary > 1350 && salary <= 2850){
                rate = 0.10f;
            }else if( salary > 2850 && salary <= 5850){
                rate = 0.15f;
            }else {
                rate = 0.2f;
            }
            tax = rate * (salary - 850);
            System.out.println("tax="+(int)(tax*100+0.5)/100.0);
        }
    }
}