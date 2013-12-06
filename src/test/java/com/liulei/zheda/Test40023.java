package com.liulei.zheda;

import java.util.Scanner;
public class Test40023{
    public static void main(String args[]){
        int ri, repeat;
        int count, i, j, k, m, n, sum;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            count = sum = 0;
            m=in.nextInt();
            n=in.nextInt();
            for(i = m; i <= n; i++){
                if(prime(i)){
                    count++;
                    sum += i;
                }
            }
            System.out.println("count="+count+", sum="+sum);
        }

    }

    public static boolean prime(int m){
        if( m == 1){
            return false;
        }else if( m == 2){
            return true;
        }else {
            int i;
            for(i = 2; i <= m / 2; i++){
                if(m % i == 0){
                    return false;
                }
            }
        }
        return true;
    }
}