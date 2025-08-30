// CYCLIC SORT

import java.util.*;

public class CyclicSort {
    //Cyclic Sort code that works only for array which contains element in range
    //Range of the element in an array of size n should be from 1 to n.
    public static void cyclicSort(int arr[]) { 
        int n = arr.length;

        int i = 0;
        while(i < n) {
            int correctIdx = arr[i] - 1; //correct index for the current element
            if(arr[i] != arr[correctIdx]) { //swap
                int temp = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = temp;
            } else {
                ++i;
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
        cyclicSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}