package com.liulei.zheda;

/**
 * Created with IntelliJ IDEA.
 * User: liulei
 * Date: 13-11-5
 * Time: 下午4:08
 * To change this template use File | Settings | File Templates.
 */
import java.io.*;
public class Test30007 {
    public static void main(String[] args)throws IOException{
        char ch;
        ch=(char)System.in.read();
        while(ch != '?'){
            String str = String.valueOf(ch);
            if(str.matches("[a-z]")){
                str = str.toUpperCase();
            }else if(str.matches("[A-Z]")){
                str = str.toLowerCase();
            }
            ch = str.charAt(0);
            System.out.print(ch);
            ch=(char)System.in.read();
        }
    }
}