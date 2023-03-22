package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ_11404_플로이드 {
    static int n, m;
    static int[][] board;

    static int SIZE = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());
        board = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(i == j) continue;
                board[i][j] = SIZE;
            }
        }

        for (int i = 0; i < m; i++) {
            String[] tmp = bf.readLine().split(" ");
            int from = Integer.parseInt(tmp[0]);
            int to = Integer.parseInt(tmp[1]);
            int cost = Integer.parseInt(tmp[2]);
            board[from][to] = Math.min(board[from][to], cost);
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    board[j][k] = Math.min(board[j][k], board[j][i] + board[i][k]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(board[i][j] >= SIZE) {
                    System.out.print("0 ");
                    continue;
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}
