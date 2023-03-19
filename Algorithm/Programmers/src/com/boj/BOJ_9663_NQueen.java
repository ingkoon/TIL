package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_9663_NQueen {
    static int n;
    static int result;
    static int[] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        board = new int[n];
        dfs(0);
        System.out.println(result);
    }

    static boolean promising(int idx){
        for (int i = 0; i < idx; i++) {
            if(board[i] == board[idx] || Math.abs(board[idx] - board[i]) == Math.abs(idx - i)){
                return false;
            }
        }
        return true;
    }

    static void dfs(int idx){
        if(idx == n){
            result++;
            return;
        }
        for (int i = 0; i < n; i++) {
            board[idx] = i;
            if(promising(idx))
                dfs(idx +1);
        }
    }
}
