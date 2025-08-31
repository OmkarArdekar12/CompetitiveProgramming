// QUICK SORT

//We can consider the pivot as also - 
//1. First Element
//2. Last Element
//3. Random Element
//4. Median-Of-Three
//5. Randomized Pivot
//6. Custom Pivot Selection
//7. Two Ends (Media Of Three)
//8. Centroid Method
//9. Hybrid Approaches
//10. Dutch National Flag Pivot

import java.util.*;

public class QuickSort {
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;
        for(int j=si; j<=ei; ++j) {
            if(arr[j] <= pivot) {
                ++i;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
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