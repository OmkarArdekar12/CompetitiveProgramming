// INSERTION SORT

import java.util.*;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        int n = arr.length;
        for(int i=1; i<n; ++i) {
            int curr = arr[i];
            int prev = i - 1;
            while((prev >= 0) && (curr < arr[prev])) {
                arr[prev + 1] = arr[prev];
                --prev;
            }
            arr[prev + 1] = curr;
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
        insertionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}