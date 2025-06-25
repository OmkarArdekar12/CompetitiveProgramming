// Grid Path

// There are 88418 paths in a 7 x 7 grid from the upper-left square to the lower-left square. 
// Each path corresponds to a 48-character description consisting of 
// characters D (down), U (up), L (left) and R (right).
// For example, the path: DRURRRRRDDDLUULDDDLDRRURDDLLLLLURULURRUULDLLDDDD.
// You are given a description of a path which may also contain characters ? (any direction). 
// Your task is to calculate the number of paths that match the description.
// Input
// The only input line has a 48-character string of characters ?, D, U, L and R.
// Output
// Print one integer: the total number of paths.
// Example
// Input:
// ??????R??????U??????????????????????????LD????D?
// Output:
// 201

import java.io.*;

public class GridPath {
    static int dirs[][] = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int n;
    static char path[];
    static boolean vis[][];
    static int totalSteps;
    static int totalPaths;
    public static void gridPath(int row, int col, int steps) {
        if(row == n - 1 && col == 0) {
            if(steps == totalSteps) {
                ++totalPaths;
            }
            return;
        }

        if(steps >= totalSteps || row < 0 || row >= n || col < 0 || col >= n || vis[row][col]) {
            return;
        }
        
        //Hit a Wall
        if(( (col > 0 && col < n-1 && !vis[row][col + 1] && !vis[row][col - 1]) && 
             ((row == 0 && vis[row + 1][col]) || (row == 6 && vis[row - 1][col])) ) ||
           ( (row > 0 && row < n-1 && !vis[row + 1][col] && !vis[row - 1][col]) &&
             ((col == 0 && vis[row][col + 1]) || (col == 6 && vis[row][col - 1])) ) 
        ) {
            return;
        }

        //Hit a Path
        if((row > 0 && row < n-1 && col > 0 && col < n-1 && vis[row + 1][col] && 
            vis[row - 1][col] && !vis[row][col + 1] && !vis[row][col - 1]) ||
           (row > 0 && row < n-1 && col > 0 && col < n-1 && vis[row][col + 1] && 
            vis[row][col - 1] && !vis[row + 1][col] && !vis[row - 1][col])
        ) {
            return;
        }

        vis[row][col] = true;
        if(path[steps] != '?') {
            int idx = "DULR".indexOf(path[steps]);
            gridPath(row + dirs[idx][0], col + dirs[idx][1], steps + 1);
        } else {
            for(int d[] : dirs) {
                gridPath(row + d[0], col + d[1], steps + 1);
            }
        }
        vis[row][col] = false;
        return;
    }

    public static void gridPathDescription(String s) {
        n = 7;
        path = s.toCharArray();
        totalSteps = s.length();
        vis = new boolean[n][n];
        totalPaths = 0;
        gridPath(0, 0, 0);
        System.out.println(totalPaths);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        gridPathDescription(s);
        br.close();
    }
}