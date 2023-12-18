package com.boj.boj17404;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, result = Integer.MAX_VALUE;
    static int INF = 1000_001;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        board = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            board[i][0] = Integer.parseInt(st.nextToken());
            board[i][1] = Integer.parseInt(st.nextToken());
            board[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < 3; i++) {
            result = Math.min(result, calc(i));
        }

        System.out.println(result);
    }

    static int calc(int idx){
        int[][] visited =  new int[n][3];

        for (int i = 0; i < n; i++)
            Arrays.fill(visited[i], INF);


        visited[0][idx] = board[0][idx];

        for (int i = 1; i < n-1; i++) {
            visited[i][0] = Math.min(visited[i-1][1], visited[i-1][2]) + board[i][0];
            visited[i][1] = Math.min(visited[i-1][0], visited[i-1][2]) + board[i][1];
            visited[i][2] = Math.min(visited[i-1][0], visited[i-1][1]) + board[i][2];
        }
        for (int i = 0; i < 3; i++) {
            if(i == idx)
                continue;
            switch (i){
                case 0:
                    visited[n-1][0] = Math.min(visited[n-2][1], visited[n-2][2]) + board[n-1][0];
                    break;
                case 1:
                    visited[n-1][1] = Math.min(visited[n-2][0], visited[n-2][2]) + board[n-1][1];
                    break;
                default:
                    visited[n-1][2] = Math.min(visited[n-2][0], visited[n-2][1]) + board[n-1][2];
            }
        }

        return Math.min(visited[n-1][0], Math.min(visited[n-1][1], visited[n-1][2]));
    }

}
