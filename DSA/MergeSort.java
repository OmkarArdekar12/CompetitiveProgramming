// MERGE SORT

import java.util.*;

public class MergeSort {
    public static void merge(int arr[], int si, int mid, int ei) {
        int n = ei - si + 1;
        int temp[] = new int[n];
        int i = si, j = mid + 1, k = 0;
        while((i <= mid) && (j <= ei)) {
            if(arr[i] < arr[j]) {
                temp[k] = arr[i];
                ++i;
            } else {
                temp[k] = arr[j];
                ++j;
            }
            ++k;
        }
        while(i <= mid) {
            temp[k] = arr[i];
            ++i;
            ++k;
        }
        while(j <= ei) {
            temp[k] = arr[j];
            ++j;
            ++k;
        }
        for(k=0, i=si; ((k<n)&&(i<=ei)); ++i, ++k) {
            arr[i] = temp[k];
        }
        return;
    }
    public static void mergeSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int mid = (si + (ei - si) / 2);
        mergeSort(arr, si, mid);
        mergeSort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
        return;
    }
    public static void mergeSort(int arr[]) {
        int n = arr.length;
        int si = 0, ei = n - 1;
        mergeSort(arr, si, ei);
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array: ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Array Elements:");
        for(int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Original Array: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}