package com.boj.boj7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
boj 7579 앱
 */
public class Main {
    static int n, m, result = Integer.MAX_VALUE, SIZE =1 ;
    static int[][] dp;
    static int[] memories;
    static int[] costs;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        memories = new int[n];
        costs = new int[n];

        StringTokenizer mem = new StringTokenizer(bf.readLine());
        StringTokenizer pri = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            memories[i] = Integer.parseInt(mem.nextToken());
            costs[i] = Integer.parseInt(pri.nextToken());
            SIZE += costs[i];
        }

        dp = new int[n][SIZE];

        for (int i = 0; i < n; i++) {
            int memory = memories[i];
            int cost = costs[i];
            for (int j = 0; j < SIZE; j++) {
                if(i == 0){
                    dp[i][j] = j >= cost ? memory : dp[i][j];
                }
                else{
                    if(cost > j)
                        dp[i][j] = dp[i-1][j];
                    else
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j - cost] + memory);
                }

                if(dp[i][j] >= m) result = Math.min(result, j);
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }

        System.out.println(result);
    }
}
