package com.boj.boj2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2193 S3 이친수
 */
public class Main {
    static int n, SIZE = 90;

    static long[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        board = new long[SIZE + 1];
        board[1] = 1;
        board[2] = 1;
        setBoard();

        System.out.println(board[n]);
    }

    static void setBoard(){
        for (int i = 3; i <= SIZE; i++) {
            board[i] = board[i-1] + board[i-2];
        }
    }
}
