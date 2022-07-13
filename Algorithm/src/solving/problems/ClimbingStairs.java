package solving.problems;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * First Problem:
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Second Problem:
 * You can climb number of steps defined by an array "steps", In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3.
 *
 * Constraints:
 *
 * 1 <= n <= 45
 */
public class ClimbingStairs {

    public static void main(String[] args) {
        System.out.println("output: " + ClimbingStairs.climbStairs(10) + ", expected: " + 89);
        System.out.println("output: " + ClimbingStairs.climbStairsBottomUp(45) + ", expected: " + 1836311903);
        System.out.println("output: " + ClimbingStairs.climbStairsBottomUp(45, new int[]{1, 2}) + ", expected: " + 1836311903);
    }

    /**
     *
     * @param n number of steps of staircase.
     * @return number of distinct ways we can go to the top if we can climb either one or two steps.
     */
    public static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return climbStairs(n - 1 ) + climbStairs(n - 2);
    }

    public static int climbStairsBottomUp(int n) {
        int[] counter = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                counter[i] = 1;
            } else {
                counter[i] = counter[i - 1] + counter[i - 2];
            }
        }
        return counter[n];
    }

    /**
     *
     * @param n number of steps of staircase.
     * @param steps define the number of steps that user can climb at once
     * @return number of distinct ways we can go to the top
     */
    public static int climbStairsBottomUp(int n, int[] steps) {
        int[] counter = new int[n + 1];
        counter[0] = 1;
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 0; j < steps.length; j++) {
                if (i >= steps[j]) {
                    total += counter[i - steps[j]];
                }
            }
            counter[i] = total;
        }
        return counter[n];
    }
}
