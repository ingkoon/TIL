package com.boj.boj17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, result;
    static int[][] board;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        board = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(new Pipe(Dir.HORIZONTAL, 1,2));

        System.out.println(result);
    }

    static void dfs(Pipe pipe){
        int r = pipe.r;
        int c = pipe.c;

        if(r == n && c == n){
            result++;
            return;
        }
        if(pipe.dir.equals(Dir.HORIZONTAL)) { // 파이프의 배치가 가로일 경우
            if(isCheck(r, c + 1)){
                dfs(new Pipe(Dir.HORIZONTAL, r, c +1));
            }
            if(isCheck(r+1, c + 1) && isCheck(r+1, c) && isCheck(r, c + 1)){
                dfs(new Pipe(Dir.DIAGONAL, r+1, c +1));
            }

        } else if (pipe.dir.equals(Dir.VERTICAL)) { // 파이프의 배치가 세로일 경우
            if(isCheck(r+1, c)){
                dfs(new Pipe(Dir.VERTICAL, r+1, c));
            }
            if(isCheck(r+1, c + 1) && isCheck(r+1, c) && isCheck(r, c + 1)){
                dfs(new Pipe(Dir.DIAGONAL, r+1, c +1));
            }

        } else{ // 파이프의 배치가 대각선일 경우
            if(isCheck(r, c + 1)){
                dfs(new Pipe(Dir.HORIZONTAL, r, c +1));
            }
            if(isCheck(r+1, c)){
                dfs(new Pipe(Dir.VERTICAL, r+1, c));
            }
            if(isCheck(r+1, c + 1) && isCheck(r+1, c) && isCheck(r, c + 1)){
                dfs(new Pipe(Dir.DIAGONAL, r+1, c +1));
            }
        }
    }

    static boolean isCheck(int r, int c){
        return 1 <= r && r <= n && 1 <= c && c <= n && board[r][c] == 0;
    }

    static class Pipe{
        Dir dir;
        int r;
        int c;

        public Pipe(Dir dir, int r, int c) {
            this.dir = dir;
            this.r = r;
            this.c = c;
        }
    }

    enum Dir{
        VERTICAL, HORIZONTAL, DIAGONAL
    }
}
