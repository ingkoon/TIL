package com.boj.boj11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 11048 이동하기
 */
public class Main {
    static int n, m;
    static int[][] board;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n+1][m+1];
        dp = new long[n+1][m+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int value = board[i][j];
                dp[i][j] = Math.max(value + dp[i-1][j], Math.max(value + dp[i][j-1], value + dp[i-1][j-1]));
            }
        }

        long result = dp[n][m];
        System.out.println(result);

    }
}

/**
 * 현재 위치에서 세 경우의 수를 돌리면서 값을 추가해나간다.
 *
 */