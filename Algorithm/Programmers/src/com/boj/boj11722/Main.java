package com.boj.boj11722;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] array;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        array = new int[n+1];
        dp = new int[n+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++)
            array[i] = Integer.parseInt(st.nextToken());

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if(array[i] < array[j] && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                } else if(array[i] == array[j])
                    dp[i] = dp[j];
            }
        }

        int result = 0;

        for (int i = 1; i <= n; i++) {
            result = Math.max(result, dp[i]);
        }

        System.out.println(result);
    }
}
