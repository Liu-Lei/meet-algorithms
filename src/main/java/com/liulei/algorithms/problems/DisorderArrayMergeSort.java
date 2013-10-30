package com.liulei.algorithms.problems;

/**
 * Created by IntelliJ IDEA.
 * User: leo
 * Date: 5/3/13
 * Time: 12:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class DisorderArrayMergeSort {

    /* An auxiliary recursive function that sorts the input array and
    returns the number of inversions in the array. */
    private static int mergeSort(int arr[], int temp[], int left, int right) {
        int mid, invCount = 0;
        if (right > left) {
            mid = (right + left) / 2;
            /* Inversion count will be sum of inversions in left-part, right-part
               and number of inversions in merging */
            invCount = mergeSort(arr, temp, left, mid);
            invCount += mergeSort(arr, temp, mid + 1, right);

            /*Merge the two parts*/
            invCount += merge(arr, temp, left, mid + 1, right);
        }
        return invCount;
    }

    /* This function merges two sorted arrays and returns inversion count in
   the arrays.*/
    private static int merge(int[] arr, int[] temp, int left, int mid, int right) {
        int i, j, k;
        int inv_count = 0;

        i = left; /* i is index for left subarray*/
        j = mid;  /* i is index for right subarray*/
        k = left; /* i is index for resultant merged subarray*/
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                System.out.println("("+arr[i] + ","+arr[j]+")");
                temp[k++] = arr[j++];
                /*this is tricky -- see above explanation/diagram for merge()*/
                inv_count = inv_count + (mid - i);
            }
        }

        /* Copy the remaining elements of left subarray
            (if there are any) to temp*/
        while (i <= mid - 1)
            temp[k++] = arr[i++];

        /* Copy the remaining elements of right subarray
            (if there are any) to temp*/
        while (j <= right)
            temp[k++] = arr[j++];

        /*Copy back the merged elements to original array*/
        for (i = left; i <= right; i++)
            arr[i] = temp[i];

        return inv_count;
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 4, 3};
        int[] temp = new int[arr.length];
        System.out.printf(" Number of inversions are %d \n", mergeSort(arr, temp, 0, arr.length - 1));

    }
}
