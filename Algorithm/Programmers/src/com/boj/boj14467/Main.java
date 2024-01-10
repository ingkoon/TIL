package com.boj.boj14467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ B1 소가 길을 건너간 이유 1
 */
public class Main {
    static int n, result, SIZE = 10;
    static int[] cows;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        cows = new int[SIZE+1];
        Arrays.fill(cows, -1);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            if(cows[num] == -1){
                cows[num] = dir;
                continue;
            }
            if(cows[num] != dir){
                result++;
                cows[num] = dir;
            }
        }

        System.out.println(result);
    }
}
