// OPTIMIZED OR MODIFIED BUBBLE SORT

import java.util.*;

public class OptimizedBubbleSort {
    public static void optimizedBubbleSort(int arr[]) {
        int n = arr.length;
        for(int i=0; i<(n-1); ++i) {
            boolean swapped = false; 
            for(int j=0; j<(n-i-1); ++j) {
                if(arr[j] > arr[j + 1]) { //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            if(!swapped) { //No element are swapped. So array is sorted.
                //help in early exiting the loop or help in the base case(array is already sorted)
                break;
            }
        }
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
        optimizedBubbleSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}