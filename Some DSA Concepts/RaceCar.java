// Race Car
// Your car starts at position 0 and speed +1 on an infinite number line. Your car can go into 
// negative positions. Your car drives automatically according to a sequence of instructions 
// 'A' (accelerate) and 'R' (reverse):
//  ● When you get an instruction 'A', your car does the following:
//      o position += speed
//      o speed *= 2
//  ● When you get an instruction 'R', your car does the following:
//      o If your speed is positive then speed = -1
//      o otherwise speed = 1 and position remains the same
// For eg., in command "AR", car goes to positions 0 -> 1 -> 1, and speed 
// goes to 1 -> 2 -> 1. Given a target position target, return the length 
// of the shortest sequence of instructions to get there.
// Input: target = 3
// Output: 2

import java.util.Arrays;

public class RaceCar {
    public static int racecar(int target) {
        int dp[] = new int[target+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        int speed = 1;
        for(int i=1; i<=target; i++) {
            if(i == (Math.pow(2, speed) - 1)) {
                dp[i] = speed;
                ++speed;
                continue;
            }

            for(int j=0; j<speed-1; j++) {
                dp[i] = Math.min(dp[i], (speed + j + 1 + dp[i - (int)Math.pow(2, speed-1) + (int)Math.pow(2, j)]));
            }
            dp[i] = Math.min(dp[i], (speed + 1 + dp[(int)Math.pow(2, speed) - 1 - i]));
        }

        return dp[target];
    }

    public static void main(String[] args) {
        int target = 3;
        System.out.println(racecar(target));
    }
}