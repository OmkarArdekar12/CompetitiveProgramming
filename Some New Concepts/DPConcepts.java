import java.util.Scanner;

public class DPConcepts {
    //Most Optimized Solution of fibonacci using Golden Ratio in Fibonacci Series
    //Can handle large size input also
    public static int fibonacciMostOptimizedSolution(int n) {
        double sqrt5 = Math.sqrt(5);
        double phi = (1 + sqrt5) / 2;
        int result = (int)((Math.pow(phi, n) - Math.pow(1 - phi, n)) / sqrt5);
        
        return result;
    }

    //Most Optimized Solution of fibonacci using Golden Ratio in Fibonacci Series
    public static int fibonacciMostOptimized(int n) {
        double phi = (1 + Math.sqrt(5)) / 2;
        double psi = (1 - Math.sqrt(5)) / 2;
        int result = (int)((Math.pow(phi, n) - Math.pow(psi, n)) / Math.pow(5, 0.5));

        return result;
    }

    //Dynamic Programming Optimized fibonacci method
    public static int fibonacciOptimized(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int a = 0, b = 1, c = 0;
        for(int i=2; i<=n; ++i) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    //Dynamic Programming Tabulation fibonacci method
    public static int fibonacciTabulation(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    //Dynamic Programming Memoization fibonacci method
    public static int fibonacciMemoization(int n, int[] memo) {
        if(n == 0 || n == 1) {
            return n;
        }

        if(memo[n] != 0) {
            return memo[n];
        }

        memo[n] = fibonacciMemoization(n-1, memo) + fibonacciMemoization(n-2, memo);
        return memo[n];
    }

    //Normal fibonacci method
    public static int fibonacci(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }

    //Method to call each fibonacci function
    public static void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the which term you want : ");
        int n = sc.nextInt();
        double startTime = 0, endTime = 0, executionTime = 0;
        System.out.println("n = " + n);
        
        System.out.println();
        System.out.println("Normal or Recursive Fibonacci Method: ");
        System.out.println("Time Complexity = O(2^n)");
        System.out.println("Space Complexity = O(n)");
        startTime = System.currentTimeMillis();
        System.out.println("Output: " + fibonacci(n));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution Time in Milliseconds = " + executionTime + " ms");
        System.out.println();

        System.out.println("Dynamic Programming Memoization Fibonacci Method: ");
        System.out.println("Time Complexity = O(n)");
        System.out.println("Space Complexity = O(n)");
        startTime = System.currentTimeMillis();
        System.out.println("Output: " + fibonacciMemoization(n, new int[n+1]));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution Time in Milliseconds = " + executionTime + " ms");
        System.out.println();

        System.out.println("Dynamic Programming Tabulation Fibonacci Method: ");
        System.out.println("Time Complexity = O(n)");
        System.out.println("Space Complexity = O(n)");
        startTime = System.currentTimeMillis();
        System.out.println("Output: " + fibonacciTabulation(n));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution Time in Milliseconds = " + executionTime + " ms");
        System.out.println();

        System.out.println("Dynamic Programming Space Optimized Fibonacci Method: ");
        System.out.println("Time Complexity = O(n)");
        System.out.println("Space Complexity = O(1)");
        startTime = System.currentTimeMillis();
        System.out.println("Output: " + fibonacciOptimized(n));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution Time in Milliseconds = " + executionTime + " ms");
        System.out.println();

        System.out.println("Fibonacci Most Optimized Method1 using Golden Ratio in Fibonacci Series: ");
        System.out.println("Time Complexity = O(log(n))");
        System.out.println("Space Complexity = O(1)");
        startTime = System.currentTimeMillis();
        System.out.println("Output: " + fibonacciMostOptimized(n));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution Time in Milliseconds = " + executionTime + " ms");
        System.out.println();

        System.out.println("Fibonacci Most Optimized Method2 (can also handle large size input) using Golden Ratio in Fibonacci Series: ");
        System.out.println("Time Complexity = O(log(n))");
        System.out.println("Space Complexity = O(1)");
        startTime = System.currentTimeMillis();
        System.out.println("Output: " + fibonacciMostOptimizedSolution(n));
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
        System.out.println("Execution Time in Milliseconds = " + executionTime + " ms");
        System.out.println();
        sc.close();
    }

    public static void main(String[] args) {
        //Fibonacci sequence -> 0 1 1 2 3 5 8 13 21...
        start();
    }
}
