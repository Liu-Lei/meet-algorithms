package com.liulei.zheda;

import java.util.Scanner;
public class Test50004{
    public static void main(String args[]){
        int ri, repeat,n;
        boolean flag;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            n=in.nextInt();
            flag = prime(n);
            if(flag) 	System.out.println("YES");
            else 	System.out.println("NO");
        }

    }
    public static boolean prime(int m){
        if( m == 1){
            return false;
        }else if( m == 2){
            return true;
        }else {
            int i;
            for(i = 2; i < m / 2; i++){
                if(m % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}