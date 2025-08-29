// Bubble Sort

import java.util.*;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for(int i=0; i<(n-1); ++i) {
            for(int j=0; j<(n-i-1); ++j) {
                if(arr[j] > arr[j + 1]) { //swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Size of the Array : "));
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0; i<n; ++i) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Original Array : " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("Sorted Array : " + Arrays.toString(arr));
    }
}