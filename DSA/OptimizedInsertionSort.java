// OPTIMIZED OR MODIFIED INSERTION SORT

import java.util.*;

public class OptimizedInsertionSort {
    public static int binarySearch(int arr[], int si, int ei, int key) {
        while(si <= ei) {
            int mid = si + (ei - si) / 2;
            if(arr[mid] == key) {
                return mid;
            } else if(arr[mid] < key) {
                si = mid + 1;
            } else {
                ei = mid - 1;
            }
        }
        return si;
    }
    public static void optimizedInsertionSort(int arr[]) {
        int n = arr.length;
        for(int i=1; i<n; ++i) {
            int key = arr[i];
            int j = binarySearch(arr, 0, i - 1, key);
            for(int k=i; k>j; --k) {
                arr[k] = arr[k - 1];
            }
            arr[j] = key;
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
        optimizedInsertionSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}
