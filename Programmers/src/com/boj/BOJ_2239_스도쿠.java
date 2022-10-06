package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2239_스도쿠 {
    static int[][] sudoku;
    static boolean flag;

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
            flag = true;
            return;
        }
        int r = cnt / 9;
        int c = cnt % 9;
        if(sudoku[r][c] != 0){
            dfs(cnt+1);
        }
        else{
            for (int i = 1; i < 10; i++) {
                if(!isCheck(r, c, i))continue;
                sudoku[r][c] = i;
                dfs(cnt+1);
                if(flag) return;
                sudoku[r][c] = 0;
            }
        }
    }

    static boolean isCheck(int r, int c, int n){
        for(int i=0;i<9;i++) {
            if(sudoku[i][c]==n || sudoku[r][i]==n) return false;
        }

        int sr = r/3 * 3;
        int sc = c - c%3;
        for(int row=sr;row<sr+3;row++) {
            for(int col=sc;col<sc+3;col++) {
                if(sudoku[row][col]==n) return false;
            }
        }
        return true;
        }
    }
}



/*
* 필요한 것은?
* 상하 검색
* 좌우 검색
* 3 * 3 검색
* */