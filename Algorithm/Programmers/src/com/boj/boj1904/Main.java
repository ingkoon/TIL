package com.boj.boj1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n, SIZE = 15746;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        dp = new int[n];

        if(n <= 2){
            System.out.println(n);
            return;
        }
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; i++) {
                dp[i] = (dp[i-1] + dp[i-2]) % SIZE;
        }
        System.out.println(dp[n-1]);
    }
}

/*
n = 1 -> 1;
n = 2 -> 2;
n = 3 -> 3; (100, 001, 111)
n = 4 -> 5;
n = 5
-> (10000, 00001, 11100, 00111, 11001, 10011, 11111)
 */
