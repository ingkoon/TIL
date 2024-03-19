package com.boj.boj14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int  x, y, k;
    static int[][] board;
    static int[] dr = {0 , 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        k = Integer.parseInt(st.nextToken());

        board = new int[y][x];

        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < x; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Dice dice = new Dice(r, c);
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < k; i++) {
            int command = Integer.parseInt(st.nextToken()) - 1;

            int nr = dice.r + dr[command];
            int nc = dice.c + dc[command];

            if(!isCheck(nr, nc)) continue;

            dice.r = nr;
            dice.c = nc;

            dice.run(command);

            if(board[nr][nc] == 0)
                board[nr][nc] = dice.numbers[5];
            else{
                dice.numbers[5] = board[nr][nc];
                board[nr][nc] = 0;
            }

            System.out.println(dice.numbers[0]);
        }
    }

    static boolean isCheck(int nr, int nc) {
        return 0 <= nr && nr < y && 0 <= nc && nc < x;
    }

    static class Dice{
        int r;
        int c;
        int[] numbers = new int[6];

        public Dice(int r, int c) {
            this.r = r;
            this.c = c;
        }

        void run(int command){
            switch (command){
                case 0:
                    right();
                    break;
                case 1:
                    left();
                    break;
                case 2:
                    up();
                    break;
                case 3:
                    down();
                    break;
                default:
                    break;
            }
        }

        void left(){ // 왼쪽으로 이동했을 때
            int tmp = numbers[5];
            numbers[5] = numbers[2];
            numbers[2] = numbers[0];
            numbers[0] = numbers[3];
            numbers[3] = tmp;

        }

        void right(){ // 오른쪽으로 이동했을 때
            int tmp = numbers[5];
            numbers[5] = numbers[3];
            numbers[3] = numbers[0];
            numbers[0] = numbers[2];
            numbers[2] = tmp;
        }

        void up(){ // 위로 이동했을 때
            int tmp = numbers[5];
            numbers[5] = numbers[4];
            numbers[4] = numbers[0];
            numbers[0] = numbers[1];
            numbers[1] = tmp;
        }

        void down(){ // 아래로 이동했을 때
            int tmp = numbers[5];
            numbers[5] = numbers[1];
            numbers[1] = numbers[0];
            numbers[0] = numbers[4];
            numbers[4] = tmp;
        }
    }
}
