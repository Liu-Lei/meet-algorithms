package com.liulei.zheda;

import java.util.Scanner;
public class Test30006{
    public static void main(String[] args){
        int ri, repeat;
        int choice;
        float price;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            System.out.println("[1] apples");
            System.out.println("[2] pears");
            System.out.println("[3] oranges");
            System.out.println("[4] grapes");
            choice=in.nextInt();
            price = 0;
            switch (choice){
                case 1:
                    price = 3.00f;
                    break;
                case 2:
                    price = 2.50f;
                    break;
                case 3:
                    price = 4.10f;
                    break;
                case 4:
                    price = 10.20f;
            }
            System.out.println("price="+price);
        }
    }
}