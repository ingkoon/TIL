package com.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_1932_정수삼각형 {
    static int n;
    static int[][] triangle;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        triangle = new int[n][];
        for (int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");
            int size = tmp.length;
            triangle[i] = new int[size];
            for (int j = 0; j < size; j++) {
                triangle[i][j] = Integer.parseInt(tmp[j]);
            }
        }

        System.out.println(solution());
    }

    static int solution(){
        int result = 0;
        int[][] dp = new int[n][n];
        dp[0][0] = triangle[0][0];

        int size = triangle.length;

        for (int i = 1; i < size; i++) {
            dp[i][0] = dp[i-1][0] + triangle[i][0]; // 첫 번째 수는 왼쪽에 있는 값을 더한다.

            for (int j = 1; j < i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }

            dp[i][i] = dp[i-1][i-1] + triangle[i][i]; // 첫 번째 수는 왼쪽에 있는 값을 더한다.
        }

        for (int i = 0; i < dp[size-1].length; i++) {
            result = Math.max(result, dp[size-1][i]);
        }
        return result;
    }
}
