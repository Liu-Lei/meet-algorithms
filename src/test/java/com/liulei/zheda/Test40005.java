package com.liulei.zheda;

/**
 * Created with IntelliJ IDEA.
 * User: liulei
 * Date: 13-11-5
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
import java.util.Scanner;
public class Test40005 {
    public static void main(String[] args) {
        int ri, repeat;
        int i, n, temp;
        float sum;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri=1; ri<=repeat; ri++){
            n=in.nextInt();
            sum = 0.0f;
            temp = 1;
	        for(i = 1; i <= n; i++){
                sum += 1 / (float)temp;
                temp += 2;
            }
            System.out.println(sum);
        }
    }
}