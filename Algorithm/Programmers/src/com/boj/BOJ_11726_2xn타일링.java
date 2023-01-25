package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726_2xn타일링 {
    static int n;
    static int[] dp;
    static int SIZE = 1001;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        dp = new int[SIZE];

        /* 피보나치 수열과 규칙이 같다. */
        dp[1] = 1;
        dp[2] = 2;

        if(n > 0) dp[1] = 1;

        for (int i = 3; i <= n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }

        int result = dp[n];

        System.out.println(result);
    }
}
