package com.practice.heaps;

/**
 * Created by Flinstone on 11-Sep-19.
 */
public class MaxHeap {

    public static  void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void max_heap(int arr[], int i, int N) {
        int left = 2 * i;
        int right = 2 * i + 1;
        int largest = i;
        if(left <= N && arr[left] > arr[i])
            largest = left;
        if(right <= N && arr[right] > arr[largest])
            largest = right;

        if(largest != i) {
            swap(arr, i, largest);
            max_heap(arr, largest, N);
        }
    }

    public static void main(String args[]) {
        int[] arr = {0,1,2,3,4,5};
        int N = arr.length - 1;
        for(int i=arr.length/2; i>=1; i--) {
            max_heap(arr, i, N);
        }

        for(int i=1; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
