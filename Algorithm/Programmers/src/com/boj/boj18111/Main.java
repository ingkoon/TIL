package com.boj.boj18111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, b;

    static int max = -1;
    static int min = Integer.MAX_VALUE;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;
                max = Math.max(tmp, max);
                min = Math.min(tmp, min);
            }
        }
        int[] result = new int[2];

        result[0] = Integer.MAX_VALUE;
        result[1] = Integer.MAX_VALUE;

        for (int i = min; i <= max; i++) {
             int[] tmp = getResult(i);
             if(tmp[0] == result[0]){
                 result[1] = Math.max(result[1], tmp[1]);
             }

             if(tmp[0] < result[0]){
                 result = tmp;
             }
        }

        System.out.println(result[0]+ " " + result[1]);
    }

    static int[] getResult(int height){
        int[] result = new int[2];
        int time = 0;
        int block = b;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int tmp = board[i][j];
                if(tmp == height)
                    continue;
                if(tmp < height){
                    time += height - tmp;
                    block -= height - tmp;
                }else{
                    time += (tmp - height) * 2;
                    block += tmp - height;
                }
            }
        }
        if(block < 0){
            return new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        }
        result = new int[] {time, height};
        return result;
    }
}