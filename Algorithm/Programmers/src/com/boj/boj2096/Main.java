package com.boj.boj2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[][] board;
    static int[][] maxDp;
    static int[][] minDp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        board = new int[n+1][3];
        maxDp = new int[n+1][3];
        minDp = new int[n+1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= n; i++) {
            maxDp[i][0] = board[i][0] + Math.max(maxDp[i-1][0], maxDp[i-1][1]);
            minDp[i][0] = board[i][0] + Math.min(minDp[i-1][0], minDp[i-1][1]);

            maxDp[i][1] = board[i][1] + Math.max(Math.max(maxDp[i-1][0], maxDp[i-1][1]), maxDp[i-1][2]);
            minDp[i][1] = board[i][1] + Math.min(Math.min(minDp[i-1][0], minDp[i-1][1]), minDp[i-1][2]);

            maxDp[i][2] = board[i][2] + Math.max(maxDp[i-1][2], maxDp[i-1][1]);
            minDp[i][2] = board[i][2] + Math.min(minDp[i-1][2], minDp[i-1][1]);
        }


        for (int[] ints : maxDp) {
            System.out.println(Arrays.toString(ints));
        }
        int maxValue = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            maxValue = Math.max(maxValue, maxDp[n][i]);
            minValue = Math.min(minValue, minDp[n][i]);
        }

        System.out.println(maxValue + " " + minValue);
    }
}
