// Number of Sub-arrays With Odd Sum
// Given an array of integers arr, return the number of subarrays with an odd sum.
// Since the answer can be very large, return it modulo 109 + 7.

class maxOddSubarraySum {
    static final int MOD = 1000000007;
    public static int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int prefixSum = 0;
        int count = 0, odd = 0, even = 0;

        for(int i=0; i<n; ++i) {
            prefixSum += arr[i];

            if(prefixSum % 2 != 0) { //oddSum
                ++count;
                count += even; //oddSum - evenSum = oddSum
                ++odd;
            } else { //evenSum
                count += odd; //evenSum - oddSum = oddSum
                ++even;
            }

            count %= MOD;
        }

        return count % MOD;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(numOfSubarrays(arr));
    }
}