package com.liulei.zheda;

import java.util.Scanner;
public class Test30010{
    public static void main(String args[]){
        int repeat, ri;
        char ch;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri = 1; ri <= repeat; ri++){
            ch=(in.next()).charAt(0);   /*输入1个字符*/
    		switch (ch){
                case 65:
                    System.out.println("90-100");
                    break;
                case 66:
                    System.out.println("80-89");
                    break;
                case 67:
                    System.out.println("70-79");
                    break;
                case 68:
                    System.out.println("60-69");
                    break;
                case 69:
                    System.out.println("0-59");
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}