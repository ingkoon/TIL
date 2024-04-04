package com.boj.boj2670;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static double[] list;
    static double[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        list = new double[n+1];
        dp = new double[n+1];

        double max = 0;

        for (int i = 1; i <= n; i++){
            list[i] = Double.parseDouble(bf.readLine());
            dp[i] = Math.max(list[i], dp[i-1] * list[i]);
            max = Math.max(max, dp[i]);
        }

        System.out.printf("%.3f%n", max);
    }
}
