package com.boj.boj14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, c, x, y, k;
    static int[][] board;
    static int[] dr = {0 , 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < c; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

    }

    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < r && 0 <= nc && nc < c;
    }

    static class Dice{
        int up, down , left, right, front, back;

        public Dice(int up, int down, int left, int right, int front, int back) {
            this.up = up;
            this.down = down;
            this.left = left;
            this.right = right;
            this.front = front;
            this.back = back;
        }

        public void moveLeft(){
            int tmp = left;
            left = up;
            up = right;
            right = down;
            down = tmp;
        }

        public void moveRight(){
            int tmp = right;
            right = up;
            up = left;
            left = down;
            down = tmp;
        }

        public void moveUp(){
            int tmp = front;
            front = up;
            up = back;
            back = down;
            down =tmp;
        }

        public void moveDown(){
            int tmp = back;
            front = up;
            up = back;
            back = down;
            down =tmp;
        }


    }
}
