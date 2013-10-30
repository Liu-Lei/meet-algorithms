package com.liulei.algorithms.sort;

/**
 * Created by IntelliJ IDEA.
 * User: leo
 * Date: 5/3/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class QuickSort {
    
    public static int partition(int[] A, int from, int to){
        int i = from - 1;
        for(int j = from ; j < to ; j++){
            if(A[j] <= A[to]){
                ++i;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }
        int temp = A[i+1];
        A[i+1] = A[to];
        A[to] = temp;
        return i+1;
    }

    public static void quickSort(int A[], int from, int to){
        if(from < to){
            int partition = partition(A,from,to);
            quickSort(A, from, partition - 1);
            quickSort(A, partition + 1, to);
        }
    }

    public static void main(String[] args) {
        int[] A = {2,3,1};
        quickSort(A,0,A.length-1);

        for(int a : A){
            System.out.print(a + " ");
        }
    }
    
}
