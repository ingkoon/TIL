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
    static int[] nums;
    static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        nums = new int[n+1];
        dp = new boolean[n+1][n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        setDp();

        m = Integer.parseInt(bf.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            System.out.println(getPalindrome(s, e));
        }
    }
    static void setDp(){
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        for (int i = 0; i <= n-1; i++) {
            if(nums[i] == nums[i+1]) dp[i][i+1] = true;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= n-i; j++) {
                if(nums[j] == nums[j+i] && dp[j+1][j+i-1])
                    dp[j][j + i] = true;
            }
        }
    }
    static int getPalindrome(int start, int end) {
       if(dp[start][end]) return 1;
       return 0;
    }
}

