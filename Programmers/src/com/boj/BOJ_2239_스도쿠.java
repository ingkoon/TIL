package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2239_스도쿠 {
    static int[][] sudoku;
    static boolean[][] visited;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String str = bf.readLine();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = str.charAt(j) - '0';
            }
        }

    }
    static void dfs(int cnt){
        if(cnt == 81){

            return;
        }
    }

    static boolean check(int r, int c, int n){
        return false;
    }
}



/*
* 필요한 것은?
* 상하 검색
* 좌우 검색
* 3 * 3 검색
* */