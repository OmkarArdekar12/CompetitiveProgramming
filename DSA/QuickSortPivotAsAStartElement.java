// QUICK SORT TAKING PIVOT AS A START OR FIRST ELEMENT

import java.util.*;

public class QuickSortPivotAsAStartElement {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return;
    }
    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[si]; //pivot as a start idx
        int i = si + 1, j = ei;
        while(i <= j) {
            while(i <= j && arr[i] <= pivot) {
                ++i;
            }
            while(i <= j && arr[j] > pivot) {
                --j;
            }
            if(i <= j) {
                swap(arr, i, j);
            }
        }
        swap(arr, si, j);
        return j;
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