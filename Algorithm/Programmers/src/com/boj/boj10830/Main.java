package com.boj.boj10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int a, b;
    static int[][] proc;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        proc = new int [a][a];
        int[][] temp = new int[a][a];

        for(int i = 0; i < a; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < a; j++) {
                int num = Integer.parseInt(st.nextToken());
                proc[i][j] = num;
                temp[i][j] = num;
            }
        }

        for (int i = 0; i < b; i++) {
            calc(temp);
        }

        for (int[] ints : proc) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static void calc(int[][] arr){
        int[][] result = new int[a][a];
        int tmp = 0;
        int cnt = 0;
        for (int i = 0; i < a; i++) {
            int num = 0;
            for (int j = 0; j < a; j++) {
                num += proc[i][j] * arr[j][i];
            }
            result[i][cnt++%a] = num;
        }
        proc = result;
    }
}
