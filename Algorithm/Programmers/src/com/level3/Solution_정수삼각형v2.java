package com.level3;

import java.util.Arrays;

public class Solution_정수삼각형v2 {
    static int SIZE;

    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }

    static int solution(int[][] triangle) {
        SIZE = triangle.length;
        int[][] dp = new int[SIZE][SIZE];
        dp[0][0] = triangle[0][0];

        for (int i = 1; i < SIZE; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0];
            for (int j = 1; j <= i; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + triangle[i][j];
            }
            dp[i][i] = dp[i-1][i-1] + triangle[i][i];

            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println("-----------------------");
        }
        int answer = 0;
        for(int i = 0; i < SIZE; i++){
            answer = Math.max(answer, dp[SIZE-1][i]);
        }
        return answer;
    }
}
