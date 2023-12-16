package com.boj.boj1503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static boolean[] board;
    static int SIZE = 1002;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new boolean[SIZE];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < m; i++) {
            board[Integer.parseInt(st.nextToken())] = true;
        }

        for (int i = 1; i < SIZE; i++) {
            if(board[i])continue;
            for (int j = 1; j < SIZE; j++) {
                if (board[j]) continue;
                for (int k = 1; k < SIZE; k++) {
                    if(board[k]) continue;
                    result = Math.min(result, Math.abs(n - i * j * k));
                }
            }
        }

        System.out.println(result);
    }
}