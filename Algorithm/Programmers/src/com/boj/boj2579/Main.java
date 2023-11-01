package com.boj.boj2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] stairs;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        stairs = new int[n+1];
        dp = new int[n+1];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(bf.readLine());
        }

        dp[1] = stairs[1];

        if(n >= 2)
            dp[2] = stairs[1] + stairs[2];

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3] + stairs[i-1]) + stairs[i];
        }
        System.out.println(dp[n]);
    }
}
