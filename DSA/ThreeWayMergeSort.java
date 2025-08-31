// 3 - WAY MERGE SORT or THREE - WAY MERGE SORT

import java.util.*;

public class ThreeWayMergeSort {
    public static void merge(int arr[], int si, int mid1, int mid2, int ei) {
        int n = ei - si + 1;
        int temp[] = new int[n];
        int i = si, j = mid1 + 1, k = mid2 + 1;
        int x = 0;
        while((i <= mid1) && (j <= mid2) && (k <= ei)) {
            if(arr[i] <= arr[j] && arr[i] <= arr[k]) {
                temp[x] = arr[i];
                ++i;
            } else if(arr[j] <= arr[i] && arr[j] <= arr[k]) {
                temp[x] = arr[j];
                ++j;
            } else {
                temp[x] = arr[k];
                ++k;
            }
            ++x;
            // if(arr[i] <= arr[j]) {
            //     if(arr[i] <= arr[k]) {
            //         temp[x] = arr[i];
            //         ++i;
            //     } else {
            //         temp[x] = arr[k];
            //         ++k;
            //     }
            // } else {
            //     if(arr[j] <= arr[k]) {
            //         temp[x] = arr[j];
            //         ++j;
            //     } else {
            //         temp[x] = arr[k];
            //         ++k;
            //     }
            // }
            // ++x;
        }
        while((i <= mid1) && (j <= mid2)) {
            if(arr[i] <= arr[j]) {
                temp[x] = arr[i];
                ++i;
            } else {
                temp[x] = arr[j];
                ++j;
            }
            ++x;
        }
        while((j <= mid2) && (k <= ei)) {
            if(arr[j] <= arr[k]) {
                temp[x] = arr[j];
                ++j;
            } else {
                temp[x] = arr[k];
                ++k;
            }
            ++x;
        }
        while((i <= mid1) && (k <= ei)) {
            if(arr[i] <= arr[k]) {
                temp[x] = arr[i];
                ++i;
            } else {
                temp[x] = arr[k];
                ++k;
            }
            ++x;
        }
        while(i <= mid1) {
            temp[x] = arr[i];
            ++i;
            ++x;
        }
        while(j <= mid2) {
            temp[x] = arr[j];
            ++j;
            ++x;
        }
        while(k <= ei) {
            temp[x] = arr[k];
            ++k;
            ++x;
        }
        for(x=0; x<n; ++x) {
            arr[si + x] = temp[x];
        }
        return;
    }
    public static void merge(int arr[], int si, int mid, int ei) {
        int n = ei - si + 1;
        int temp[] = new int[n];
        int i = si, j = mid + 1;
        int k = 0;
        while((i <= mid) && (j <= ei)) {
            if(arr[i] <= arr[j]) {
                temp[k] = arr[i];
                ++i;
            } else {
                temp[k] = arr[j];
                ++j;
            }
            ++k;
        }
        while(i <= mid) {
            temp[k] = arr[i];
            ++i;
            ++k;
        }
        while(j <= ei) {
            temp[k] = arr[j];
            ++j;
            ++k;
        }
        for(k=0; k<n; ++k) {
            arr[si + k] = temp[k];
        }
        return;
    }
    public static void threeWayMergeSort(int arr[], int si, int ei) {
        if(si >= ei) {
            return;
        }
        // if(ei - si < 1) {
        //     return;
        // }

        int mid1 = (si + (ei - si) / 3);
        int mid2 = (si + 2 * (ei - si) / 3 + 1);

        threeWayMergeSort(arr, si, mid1);
        threeWayMergeSort(arr, mid1 + 1, mid2);
        threeWayMergeSort(arr, mid2 + 1, ei);

        // merge(arr, si, mid1, mid2);
        // merge(arr, si, mid2, ei);
        merge(arr, si, mid1, mid2, ei);

        return;
    }
    public static void threeWayMergeSort(int arr[]) {
        int n = arr.length;
        int si = 0, ei = n - 1;
        threeWayMergeSort(arr, si, ei);
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
        threeWayMergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
        sc.close();
    }
}