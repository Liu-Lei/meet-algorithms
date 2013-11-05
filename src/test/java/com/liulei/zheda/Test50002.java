package com.liulei.zheda;

/**
 * Created with IntelliJ IDEA.
 * User: liulei
 * Date: 13-11-5
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
import java.util.Scanner;
public class Test50002 {
    public static void main(String args[]){
        int ri, repeat;
        int i, n,a;
        long sn;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            a=in.nextInt();
            n=in.nextInt();
            sn = 0l;
            for(i = 1; i <= n; i++){
                sn += fn(a, i);
            }
            System.out.println(sn);
        }
    }
    public static int fn(int a, int n){
        int sum = 0;
        for(int i = 0;i < n; i++){
            sum += Math.pow(10,i)*a;
        }
        return sum;
    }
}