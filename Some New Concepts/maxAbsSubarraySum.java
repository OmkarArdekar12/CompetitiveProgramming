// Maximum Absolute Sum of Any Subarray
// You are given an integer array nums. 
// The absolute sum of a subarray 
// [numsl, numsl+1, ..., numsr-1, numsr] is abs(numsl + numsl+1 + ... + numsr-1 + numsr).
// Return the maximum absolute sum of any (possibly empty) subarray of nums.
// Note that abs(x) is defined as follows:
// If x is a negative integer, then abs(x) = -x.
// If x is a non-negative integer, then abs(x) = x.

public class maxAbsSubarraySum {
    public static int maxAbsoluteSum(int[] nums) {
        int n = nums.length;

        int currSum1 = 0, maxSum = 0;
        int currSum2 = 0, minSum = 0;
        for(int i=0; i<n; ++i) {
            currSum1 += nums[i];
            currSum2 += nums[i];
            
            maxSum = Math.max(maxSum, currSum1);
            minSum = Math.min(minSum, currSum2);

            if(currSum1 < 0) {
                currSum1 = 0;
            }
            if(currSum2 > 0) {
                currSum2 = 0;
            }
        }

        return Math.abs(maxSum) < Math.abs(minSum) ? Math.abs(minSum) : Math.abs(maxSum);
    }

    public static void main(String[] args) {
        int nums[] = {1, -3, 2, 3, -4};
        System.out.println(maxAbsoluteSum(nums));
    }
}
