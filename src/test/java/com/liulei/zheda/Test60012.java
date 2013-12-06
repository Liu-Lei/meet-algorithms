package com.liulei.zheda;

import java.util.Scanner;
public class Test60012{
    public static void main(String []args){
        int ri, repeat;
        int i,j,n,a[][]=new int[10][10];
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            n=in.nextInt();
            a[0][0] = 1;
            a[0][1] = 1;
            a[0][2] = 2;
            a[0][3] = 3;
            a[1][0] = 1;
            a[1][1] = 2;
            a[2][0] = 2;
            a[2][1] = 3;
            a[2][2] = 4;
            a[3][0] = 3;
            a[3][1] = 4;
            a[3][2] = 5;
            a[3][3] = 6;
            for( i=0; i<=n; i++ ){
                for( j=0; j<=n; j++ )
                    if(i==0&&j==0) System.out.print( "+   ");
                    else if(i==0||j<=i) System.out.print( a[i][j]+"   ");
                System.out.println();
            }
        }
    }
}