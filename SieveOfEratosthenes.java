// Closest Prime Numbers in Range
// Given two positive integers left and right, find the two integers num1 and num2 such that:
// left <= num1 < num2 <= right
// Both num1 and num2 are prime numbers.
// num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
// Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, 
// return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
// Input: left = 9, right = 45
// Output: [11,13]

import java.util.*;

public class SieveOfEratosthenes {
    static class MostOptimizedApproach {
        static List<Integer> primes;
        public static void getPrimes(int si, int ei) {
            boolean arr[] = new boolean[ei+1];
            arr[0] = arr[1] = true;
    
            for(int i=2; i<=Math.sqrt(ei); ++i) {
                if(arr[i]) {
                    continue;
                }
    
                for(int j=i*i; j<=ei; j+=i) {
                    arr[j] = true;
                }
            }
            
            for(int i=si; i<=ei; ++i) {
                if(!arr[i]) {
                    primes.add(i);
                }
            }
    
            return;
        }
        
        public static int[] closestPrimes(int left, int right) {
            primes = new ArrayList<>();
            getPrimes(left, right);
            int n = primes.size();
            
            int minDiff = Integer.MAX_VALUE, num1 = -1, num2 = -1;
            for(int i=0, j=1; j<n; ++i, ++j) {
                if((primes.get(j) - primes.get(i)) < minDiff) {
                    minDiff = primes.get(j) - primes.get(i);
                    num1 = primes.get(i);
                    num2 = primes.get(j);
                }
            }
            
    
            return new int[]{num1, num2};
        }
    }
    
    static class OptimizedApproach {
        // Sieve of Eratosthenes Algorithm Explanation
        // In Brute force Approach, to find the prime number in a range, we traverse in the range and check for each 
        // number it is prime. To check the number is the prime we traverse from 2 to square root of the number. 
        // because, after the square root the factors are repeated And previous numbers have already checked that repeated factors.
        // So, In Brute force TC = O(n*sqrt(n)), where n = upper limit of the range.
        // SIEVE OF ERATOSTHENES ALGORITHM - BASED ON INVERT THINKING OR REVERSE THINKING
        // In Sieve of Eratosthenes Algorithm, we invert our thinking, instead of find the prime numbers we try to find the 
        // numbers which are not prime.
        // Invert Thinking -> Think Invert and Reverse. Solution to Problem not Problem to Solution
        // We traverse in the range (0 to n) and mark all multiple of current number to not prime. And at the end after the traversing
        // the range is finish the number which are not mark as not prime they are finally our Prime numbers.
        // There also 2 slight optimization in the sieve algorithm, 
        // if the range upper limit is N, then we traverse till square root of N only, because of 2 reasons.
        // first reason, after the sqrt(N), the factor repeat itself, 
        // eg1-> factors of 4 are: 1 x 4, 2 x 2, 4 x 1.
        // You can see in the above eg1 that after the sqrt(4) i.e. 2, our factor 1 and 4 repeat them self.
        // second reason, the number after the sqrt(n) are already visited/checked.
        // eq2-> n = 100, sqrt(n) = 10, if traverse the multiples of 12, it will be 24, 36, 48 ... and so on.
        // but this multiples of 12 are already visited by number 2, 3, 6 & 8.
        // So, 2 optimization are we traverse from 2 to sqrt(n). 
        // And we don't traverse the multiples of number which is already checked(or already mark as not prime)
        // TC of Sieve of Eratosthenes is O(n*log(log(n))).
        // TC = Time Complexity & SC = Space Complexity
    
        // Sieve of Eratosthenes Algorithm
        // TC = O(n * log(log(n))) & SC = O(n), where n = right + 1
        public static List<Integer> getPrimes(int si, int ei) {
            boolean arr[] = new boolean[ei+1];
            Arrays.fill(arr, true); // Assuming that all numbers in the range are prime
            arr[0] = arr[1] = false; // 0 & 1 are no prime numbers
    
            for(int i=2; i<=Math.sqrt(ei); ++i) { // loop can also be -> for(int i=2; i*i<=ei; ++i)
                if(!arr[i]) { //not travering the multiples of the number which is already marked as not prime
                    continue;
                }
    
                for(int j=i*i; j<=ei; j+=i) {
                    arr[j] = false;
                }
            }
    
            List<Integer> primes = new ArrayList<>();
            for(int i=si; i<=ei; ++i) { // get the prime numbers which is in the given range
                if(arr[i]) {
                    primes.add(i);
                }
            }
    
            return primes;
        }
        
        // Final TC & SC
        // TC = O((n * log(log(n))) + (x - y + 1)), where n = right + 1, x = left, y = right
        // SC = O(n), where n = right + 1
        public static int[] closestPrimes(int left, int right) {
            List<Integer> primes = getPrimes(left, right);
            int n = primes.size();
            int minDiff = Integer.MAX_VALUE, num1 = -1, num2 = -1;
            for(int i=0, j=1; j<n; ++i, ++j) {
                if((primes.get(j) - primes.get(i)) < minDiff) {
                    minDiff = primes.get(j) - primes.get(i);
                    num1 = primes.get(i);
                    num2 = primes.get(j);
                }
            }
            
    
            return new int[]{num1, num2};
        }
    }
    
    static class BruteForceApproach {
        public static boolean isPrime(int n) {
            if(n < 2) {
                return false;
            }
    
            for(int i=2; i<=Math.sqrt(n); ++i) {
                if(n%i == 0) {
                    return false;
                }
            }
    
            return true;
        }
    
        public static int[] closestPrimes(int left, int right) {
            List<Integer> al = new ArrayList<>();
            for(int i=left; i<=right; ++i) {
                if(isPrime(i)) {
                    al.add(i);
                }
            }
            
            int minDiff = Integer.MAX_VALUE, num1 = -1, num2 = -1;
            for(int i=0, j=1; j<al.size(); ++i, ++j) {
                if(minDiff > (al.get(j) - al.get(i))) {
                    minDiff = al.get(j) - al.get(i);
                    num1 = al.get(i);
                    num2 = al.get(j);
                }
            }
    
            return new int[]{num1, num2};
        }
    }
    public static void main(String[] args) {
        int left = 9, right = 45;
        System.out.println("Brute Force Approach Result = " + Arrays.toString(BruteForceApproach.closestPrimes(left, right)));
        System.out.println("Optimized Approach Result = " + Arrays.toString(OptimizedApproach.closestPrimes(left, right)));
        System.out.println("Most Optimized Approach Result = " + Arrays.toString(MostOptimizedApproach.closestPrimes(left, right)));
    }
}