// COUNTING SORT

//Counting Sort only works for the positive integer and it is efficient to used the
//counting sort when we give the small range of the positive integer

import java.util.*;

public class CountingSort {
    public static void countingSort(int arr[]) { //Counting Sort code that work on both positive and negative integers
        int n = arr.length;
        
        int smallest = Integer.MAX_VALUE, largest = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i) {
            smallest = Math.min(smallest, arr[i]);
            largest = Math.max(largest, arr[i]);
        }

        int size = largest - smallest + 1;
        int count[] = new int[size];
        for(int i=0; i<n; ++i) {
            int curr = arr[i] - smallest;
            ++count[curr];
        }

        for(int i=0, j=0; i<size; ++i) {
            while(count[i] > 0) {
                arr[j] = i + smallest;
                ++j;
                --count[i];
            }
        }

        return;
    }

    public static void countingSortOnlyPositive(int arr[]) { //Counting Sort code that work only for positive numbers
        int n = arr.length;
        
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<n; ++i) {
            largest = Math.max(largest, arr[i]);
        }

        int count[] = new int[largest + 1];
        for(int i=0; i<n; ++i) {
            int curr = arr[i];
            ++count[curr];
        }

        for(int i=0, j=0; i<=largest; ++i) {
            while(count[i] > 0) {
                arr[j] = i;
                ++j;
                --count[i];
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
        countingSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}