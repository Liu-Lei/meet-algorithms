package com.liulei.algorithms.sort;

/**
 * Created by IntelliJ IDEA.
 * User: leo
 * Date: 5/3/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class MergeSortWiki {

    public static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length || j < right.length) {
            if (i < left.length && j < right.length) {
                if (left[i] <= right[j]) {
                    result[k++] = left[i++];
                } else {
                    result[k++] = right[j++];
                }
            } else if (i < left.length) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        return result;
    }

    public static int[] mergeSort(int[] A) {
        if (A.length <= 1) {
            return A;
        }

        int middle = A.length / 2;
        int[] left = new int[middle];
        int[] right = new int[A.length - middle];
        for (int i = 0; i < middle; i++) {
            left[i] = A[i];
        }
        for (int i = middle; i < A.length; i++) {
            right[i-middle] = A[i];
        }
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left,right);
    }


    public static void main(String[] args) {
        int[] a = {2, 50, 8, 95, 6, 8, 10};
        for (int i : mergeSort(a)) {
            System.out.print(i + " ");
        }
    }


}
