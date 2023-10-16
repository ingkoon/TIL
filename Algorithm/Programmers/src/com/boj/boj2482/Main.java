package com.boj.boj2482;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
백준 2482번 색상환
 */
public class Main {
    static int n, k;
    static int MOD = 1000000003;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        k = Integer.parseInt(bf.readLine());

        System.out.println(solution());

    }

    static int solution(){
        if(k > n / 2)
            return 0;

        int[][] dp = new int[n+1][k+1];

        for (int i = 1; i <= n; i++)
            dp[i][1] = i;

        for (int i = 4; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i-2][j-1]) % MOD;
            }
        }
        return dp[n][k];
    }
}
/*
n개의 색이 존재하는 색상환에서 연속되지 않는 상태에서 k개를 고른다.

 */