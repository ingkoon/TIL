package com.boj.boj2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static int[] coins;
    static int[][] dp;

    static final int MAX = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        coins = new int[n+1];
        dp = new int[n+1][k+1];

        for (int i = 1; i <= n; i++)
            coins[i] = Integer.parseInt(bf.readLine());
        Arrays.sort(coins);

        for (int i = 0; i <= n; i++) { // 초기화
            for (int j = 1; j <= k; j++) {
                dp[i][j] = MAX;
            }
        }

        for (int i = 1; i <= n; i++) {
            setCount(i);
        }

        int result = MAX;
        for (int i = 1; i <= n; i++) {
            result = Math.min(result, dp[i][k]);
        }

        System.out.println(result == MAX ? -1 : result);
    }

    static void setCount(int idx){
        int coin = coins[idx];
        for(int i = 1; i < coin; i++){
            if(i == k) break;
            dp[idx][i] = dp[idx-1][i];
        }
        for (int i = coin; i <= k; i++) {
            dp[idx][i] = Math.min(dp[idx-1][i], dp[idx][i-coin]+1);
        }
    }
}
/*
0 0 0 0 0 0 0 0 0 0 0  0  0  0  0  0
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
0 1 2 3 4 1 2 3 4 5 2  3  4  5  6  3
0 1 2 3 4 1 2 3 4 5 2  3  1  2  3  4
 */
