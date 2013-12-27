package com.liulei.zheda;

import java.util.Scanner;
public class Test60005{
    public static void main(String []args){
        int ri, repeat;
        int i, index, k, n, temp,a[];
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            n=in.nextInt();
            a=new int[n];
            for(i=0; i<n; i++)
                a[i]=in.nextInt();
            for(index = 0; index < n; index++){
                for(k = index + 1; k < n; k++){
                    if(a[index] < a[k]){
                        temp = a[index];
                        a[index] = a[k];
                        a[k] = temp;
                    }
                }
            }
            for(i=0; i<n; i++)
                System.out.print(a[i]+" ");
            System.out.println();
        }
    }
}