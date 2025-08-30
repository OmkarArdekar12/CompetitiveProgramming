// OPTIMIZED OR MODIFIED SELECTION SORT

import java.util.*;

public class OptimizedSelectionSort {
    public static void optimizedSelectionSort(int arr[]) {
        int n = arr.length;
        for(int i=0; i<(n-1); ++i) {
            int minPositionIdx = i;
            boolean swapped = false;
            for(int j=(i+1); j<n; ++j) {
                if(arr[j] < arr[minPositionIdx]) {
                    swapped = true;
                    minPositionIdx = j;
                }
            }
            if(swapped) { //swap
                int temp = arr[minPositionIdx];
                arr[minPositionIdx] = arr[i];
                arr[i] = temp;
            }
        }
        return;
    }
    public static void modifiedSelectionSort(int arr[]) {
        int n = arr.length;
        for(int i=0; i<(n-1); ++i) {
            int minPositionIdx = i;
            for(int j=(i+1); j<n; ++j) {
                if(arr[j] < arr[minPositionIdx]) {
                    minPositionIdx = j;
                }
            }
            if(minPositionIdx != i) { //swap
                int temp = arr[minPositionIdx];
                arr[minPositionIdx] = arr[i];
                arr[i] = temp;
            }
        }
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
        // optimizedSelectionSort(arr);
        modifiedSelectionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}