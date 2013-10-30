package com.liulei.algorithms.sort;

/**
 * Created by IntelliJ IDEA.
 * User: leo
 * Date: 5/3/13
 * Time: 5:55 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSort {
    public static void mergeSort(int[] A, int p, int r){
        if(p < r){
            int mid = (p + r) / 2;
            mergeSort(A, p, mid);
            mergeSort(A, mid+1, r);
            merge(A, p, mid, r);
        }
    }

    public static void merge(int[] A, int p, int mid, int r) {
        int n1 = mid - p + 1;
        int n2 = r - mid;

        int[] L1 = new int[n1+1];
        int[] L2 = new int[n2+1];
        
        for(int i = 0; i < n1; i++){
            L1[i] = A[p + i];
        }
        
        for(int j = 0; j < n2; j++){
            L2[j] = A[mid+j+1];
        }
        L1[n1] = L2[n2] = Integer.MAX_VALUE;
        int i = 0, j = 0;
        for(int k = p; k <= r; k++){
            if(L1[i] <= L2[j]){
                A[k] = L1[i++];
            }else {
                A[k] = L2[j++];
            }
        }
    }

    public static void main(String[] args) {
        int A[] = {2,6,1,12,16,50,23};
        mergeSort(A,0,A.length-1);
        for(int a : A){
            System.out.print(a + " ");
        }
    }
}
