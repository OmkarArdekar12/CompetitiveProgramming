// Tiling Problem
// Given a “2 x n” board and tiles of size “2 x 1”, the task is to count the number of ways to 
// tile the given board using the 2 x 1 tiles. A tile can either be placed horizontally 
// i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile. 

import java.util.*;

public class TilingProblem {
    //Understand the Pattern of fibonacci series and using binet formula
    //TC = O(1), SC = O(1)
    public static int mostOptimized(int n) {
        ++n;

        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        int res = (int)((Math.pow(phi, n) - Math.pow(1 - phi, n)) / sqrt5);

        return res;
    }
    
    //Dynamic Programming - Space Optimization Tabulation - Bottom Up
    //TC = O(n), SC = O(1)
    public static int dpSpaceOptimized(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int a = 1, b = 1, c = 0;
        for(int i=2; i<=n; ++i) {
           c = a + b;
           a = b;
           b = c;
        }
       
        return c;
    }
    
    //Dynamic Programming - Tabulation - Bottom Up
    //TC = O(n), SC = O(n)
    public static int dpTabulation(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int dp[] = new int[n+1];
        dp[0] = dp[1] = 1;
        for(int i=2; i<=n; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
       
        return dp[n];
    }
    
    //Dynamic Programming - Memoization - Top Down
    //TC = O(n), SC = O(n)
    public static int dpMemoization(int n, int[] memo) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }

        if(memo[n] != 0) { //can fill the memo with -1 also and check memo[n] != -1
            return memo[n];
        }
        
        int way1 = dpMemoization(n - 1, memo);
        int way2 = dpMemoization(n - 2, memo);
        int totalWays = way1 + way2;
       
        return memo[n] = totalWays;
    }

    //Recursion
    //TC = O(2^n), SC = O(n)
    public static int numberOfWays(int n) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        
        int way1 = numberOfWays(n - 1);
        int way2 = numberOfWays(n - 2);
        int totalWays = way1 + way2;
       
        return totalWays;
    }

    public static void main(String[] args) {
        //TC = Time Complexity, SC = Space Complexity
        int n = 5;
        System.out.println("result = " + numberOfWays(n));
        System.out.println("result = " + dpMemoization(n, new int[n+1]));
        System.out.println("result = " + dpTabulation(n));
        System.out.println("result = " + dpSpaceOptimized(n));
        System.out.println("result = " + mostOptimized(n));
    }
}
