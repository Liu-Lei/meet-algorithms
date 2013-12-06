package com.liulei.zheda;

import java.util.Scanner;
public class Test40009 {
    public static void main(String[] args){
        int ri, repeat;
        int i , max, n, x;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            n=in.nextInt();
            max = Integer.MIN_VALUE;
            for(i = 1; i <= n; i++){
                x = in.nextInt();
                if(x > max){
                    max = x;
                }
            }
            System.out.println(max);
        }
    }
}