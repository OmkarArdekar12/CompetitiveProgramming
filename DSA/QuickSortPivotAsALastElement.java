// QUICK SORT TAKING PIVOT AS A END OR LAST ELEMENT

import java.util.*;

public class QuickSortPivotAsALastElement {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; //pivot as a last idx
        int i = si - 1;
        for(int j=si; j<ei; ++j) {
            if(arr[j] <= pivot) {
                ++i;
                swap(arr, i, j);
            }
        }
        ++i;
        swap(arr, i, ei);
        return i;
    }
    public static void quickSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        int partitionIdx = partition(arr, si, ei);
        quickSort(arr, si, partitionIdx - 1);
        quickSort(arr, partitionIdx + 1, ei);
        return;
    }
    public static void quickSort(int arr[]) {
        int n = arr.length;
        int si = 0, ei = n - 1;
        quickSort(arr, si, ei);
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
        quickSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}