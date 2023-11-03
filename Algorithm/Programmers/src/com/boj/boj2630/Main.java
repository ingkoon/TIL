package com.boj.boj2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * boj 2630 색종이 만들기
 */
public class Main {
    static int n;
    static int[] result;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        board = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        result = new int[2];
        recur(0,0, n);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    static void recur(int r, int c, int size){
        if (isCheck(r, c, size)){
            result[board[r][c]] ++;
            return;
        }
        int nextSize = size/2;
        recur(r, c, nextSize);
        recur(r, c + nextSize, nextSize);
        recur(r + nextSize, c, nextSize);
        recur(r + nextSize, c + nextSize, nextSize);
    }

    static boolean isCheck(int r, int c, int size){
        int value = board[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if(board[i][j]!=value)
                    return false;
            }
        }
        return true;
    }
}
