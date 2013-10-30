package com.liulei.algorithms.problems;

/**
 * Created by IntelliJ IDEA.
 * User: leo
 * Date: 5/3/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisorderArray {
    /**
     * The normal method to get the disorder group of array
     * This algorithm's time complexity is O(n^2)
     * @param array
     */
    public static void getDisorderGroup(int[] array){
        int groupCount = 0;
        for(int i = 0; i < array.length-1; i++){
            for(int j = i + 1; j < array.length; j++ ){
                if(array[i] > array[j]){
                    System.out.println(++groupCount+": ("+array[i]+", "+array[j]+")");
                }
            }
        }
    }


    public static void main(String[] args) {
        getDisorderGroup(new int[]{1,2,5,4,3});
    }
}
