package com.boj.boj10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
boj 10942 펠린드롬?
 */
public class Main {
    static int n, m;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int[] nums = new int[n+1];
        dp = new boolean[n+1][n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        setDp(nums);

        m = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(dp[s][e] ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }
    static void setDp(int[] nums){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if(i == j) dp[i][j] = true;
                else if(i - j == 1) dp[j][i] = nums[i] == nums[j];
                else{
                    dp[j][i] = nums[i] == nums[j] && dp[j+1][i-1];
                }
            }
        }
    }
}

