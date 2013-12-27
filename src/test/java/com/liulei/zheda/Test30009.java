package com.liulei.zheda;
/**
 *   关于一元二次方程，题目描述不是特别清楚，所以不知如何完成，题目如下：
     程序填空，不要改变与输入输出有关的语句。
     输入一个正整数repeat (0<repeat<10)，做repeat次下列运算：
     输入参数a,b,c，求一元二次方程a*x*x＋b*x＋c＝0的根，结果保留2位小数(如果答案为3.50，则直接显示为3.5)。
     按情况分别输出以下内容（文字中的标点为西文标点，无空格。括号内为说明）：
     （1）a=b=c=0,meaningless
     （2）a=b=0,c!=0,error
     （3）x=值             （值为-c/b）
     （4）x1=值1           （值1为(-b+Math.sqrt(d))/(2*a)）
     x2=值2           （值2为(-b-Math.sqrt(d))/(2*a)）
     （5）x1=值1+值2i
     x2=值1-值2i     （值1为-b/(2*a)，值2为Math.sqrt(-d)/(2*a)）
     输入输出示例：括号内为说明
     输入：
     5               (repeat=5)
     0 0 0           (a=0,b=0,c=0)
     0 0 1           (a=0,b=0,c=1)
     0 2 5           (a=0,b=2,c=5)
     21 89 35     (a=21,b=89,c=35)
     2 2 3           (a=2,b=2,c=3)
     输出：
     a=b=c=0,meaningless
     a=b=0,c!=0,error
     x=-2.5
     x1=-0.44
     x2=-3.8
     x1=-0.5+1.12i
     x2=-0.5-1.12i
 */
import java.util.Scanner;
public class Test30009{
    public static void main(String args[]){
        int repeat, ri;
        int a,b,c,d;
        double x1,x2;
        Scanner in=new Scanner(System.in);
        repeat=in.nextInt();
        for(ri = 1; ri <= repeat; ri++){
            a=in.nextInt();b=in.nextInt();c=in.nextInt();
    		/*---------*/
        }
    }
}