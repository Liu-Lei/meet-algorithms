package com.liulei.algorithms.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leo
 * Date: 6/27/13
 * Time: 3:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class BuyThings {



    public static void main(String[] args) {

        Integer m = 5, n = 3;

        for(int i = 1; i <= n; i++){
            getSatisfyCombination(m,n,i);
        }


    }

    private static void getSatisfyCombination(Integer m, Integer n, int count) {

        List<List<Integer>> allCombination = new ArrayList<List<Integer>>();

        int[] initNumber = new int[n];

        for(int i = 0; i < n; i++){
            initNumber[i] = i+1;
        }

        List<Integer> comList = getCombinationList(initNumber,count);


    }

    private static List<Integer> getCombinationList(int[] initNumber, int count) {
        List<Integer> comList = new ArrayList<Integer>();

        if(count == 1){
            for(int num : initNumber){
                comList.add(num);
            }
        }else {

        }



        return comList;
    }

}
