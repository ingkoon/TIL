package com.boj.boj16922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 16922 로마 숫자 만들기
 */
public class Main {
    static int n;
    static int[] arr = {1, 5, 10, 50};
    static int SIZE = 1001;
    static boolean[][] visited;
    static boolean[] isResult;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        isResult = new boolean[SIZE];

        n = Integer.parseInt(bf.readLine());
        visited = new boolean[n][SIZE];

        search(0, 0);

        for (boolean b : isResult) {
            if(b) result++;
        }

        System.out.println(result);
    }


    static void search(int idx, int num) {
        if(idx == n){
            isResult[num] = true;
            return;
        }

        for(int val : arr){
            int next = num + val;
            if(visited[idx][next])
                continue;
            visited[idx][next] = true;
            search(idx+1, next);
        }
    }
}
