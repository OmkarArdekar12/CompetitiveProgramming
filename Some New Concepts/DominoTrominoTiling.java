//Domino and Tromino Tiling
//You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
//Given an integer n, return the number of ways to tile an 2 x n board.
//Since the answer may be very large, return it modulo 109 + 7.
//In a tiling, every square must be covered by a tile.
//Two tilings are different if and only if there are two 4-directionally adjacent cells
//on the board such that exactly one of the tilings has both squares occupied by a tile.

import java.util.*;

class Solution1 {
    // static int makeState(boolean t1, boolean t2) {
    //     // if(!t1 && !t2) {
    //     //     return 0;
    //     // }
    //     // if(t1 && !t2) {
    //     //     return 1;
    //     // }
    //     // if(!t1 && t2) {
    //     //     return 2;
    //     // }
    //     // if(!t1 && t2) {
    //     //     return 3;
    //     // }
    //     // if(!t1 && !t2) {
    //     //     return 0;
    //     // }
    //     // if(t1 && !t2) {
    //     //     return 1;
    //     // }
    //     // if(!t1 && t2) {
    //     //     return 2;
    //     // }
    //     // return 3;
    // }
    
    //Logic
    // t1 t3
    // t2 t4

    // false = already placed / can't placed tile
    // true = empty / can placed tile

    // vertical Domino (vd) = | , horizontal Domino (hd) = -

    // straight1 Tromino (s1t) = |￣ , straight2 Tromino (s2t) = |_

    // reverse1 Tromino (r1t) = ￣| , reverse2 Tromin (r2t) = _|
    
    static int MOD = 1000000007;
    static int N;
    static int dp[][];
    static int makeState(boolean t1, boolean t2) {
        int state = 0;
        if(t1) {
            state |= 1;
        }
        if(t2) {
            state |= 2;
        }
        return state;
    }
    
    // vertical Domino (vd) = |, horizontal Domino (hd) = -
    // straight1 Tromino (s1t) = |￣, straight2 Tromino (s2t) = |_
    // reverse1 Tromino (r1t) = ￣|, reverse2 Tromin (r2t) = _|
    public static int dominoTromino(int i, boolean t1, boolean t2) {
        if(i == N) {
            return 1;
        }
        
        int state = makeState(t1, t2);
        if(dp[i][state] != -1) {
            return dp[i][state];
        }

        boolean t3 = i+1 < N, t4 = i+1 < N;
        int count = 0;
        if(t1 && t2 && t3) { //for one s1t
            count += dominoTromino(i+1, false, true);
        }
        if(t1 && t2 && t4) { //for one s2t
            count += dominoTromino(i+1, true, false);
        }
        if(t1 && !t2 && t3 && t4) { //for one r1t
            count += dominoTromino(i+1, false, false);
        }
        if(!t1 && t2 && t3 && t4) { //for one r2t
            count += dominoTromino(i+1, false, false);
        }
        if(t1 && t2) { //for one vd
            count += dominoTromino(i+1, true, true);
        }
        if(t1 && t2 && t3 && t4) { //for two hd
            count += dominoTromino(i+1, false, false);
        }
        if(t1 && !t2 && t3) { //for one hd
            count += dominoTromino(i+1, false, true);
        }
        if(!t1 && t2 && t4) { //for one hd
            count += dominoTromino(i+1, true, false);
        }
        if(!t1 && !t2) { //for t1 & t2 already placed in previous (previously placed two hd)
            count += dominoTromino(i+1, true, true);
        }

        return dp[i][state] = count % MOD;
    }

    
    public int numTilings(int n) {
        N = n;
        dp = new int[n+1][4];
        for(int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return dominoTromino(0, true, true);
    }
}

class Solution2 {
    static int MOD = 1000000007;

    //understanding the pattern
    public int numTilings(int n) {
        int t1 = 0, t2 = 1, t3 = 1, t4 = 2;
        while(--n > 0) {
            t4 = ((t3 * 2) % MOD + t1) % MOD;
            t1 = t2;
            t2 = t3;
            t3 = t4;
        }

        return t3;
    }
}

public class DominoTrominoTiling {
    public static void main(String[] args) {
        int n = 12;
        Solution1 obj1 = new Solution1();
        System.out.println(obj1.numTilings(n));
        Solution2 obj2 = new Solution2();
        System.out.println(obj2.numTilings(n));
    }
}

