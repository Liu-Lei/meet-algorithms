package com.liulei.zheda;

import java.util.Scanner;
public class Test50006{
    public static void main(String args[]){
        int ri,repeat;
        int i, m, n;
        long f;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            m=in.nextInt();
            n=in.nextInt();
            for(i = 1, f = fib(i); f <= n; i++){
                f = fib(i);
                if(f >= m && f <= n){
                    System.out.print(f+" ");
                }

            }
            System.out.println();
        }
    }
    public static int fib(int num){
        if(num == 1 || num == 2){
            return 1;
        }else{
            return fib(num -1) + fib(num - 2);
        }
    }
}