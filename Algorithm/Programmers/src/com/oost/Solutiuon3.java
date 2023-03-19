package com.oost;

import java.util.Arrays;

public class Solutiuon3 {
    public static void main(String[] args) {
        String s  = "<><??>>";
        String s2 = "<<?";
        String s3 = "??????";
        System.out.println(solution(s));
    }
    static int solution(String S){
        int n = S.length();
        int[][] dp = new int[n][n];
        int maxLen = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                } else if (S.charAt(i) == '<' || S.charAt(i) == '>') {
                    if (j == i + 1) {
                        dp[i][j] = 2;
                    } else {
                        if (i + 1 < n && j - 1 >= 0 && dp[i + 1][j - 1] > 0) {
                            dp[i][j] = 2 + dp[i + 1][j - 1];
                        } else {
                            dp[i][j] = 2;
                        }
                    }
                }
                if (i + 1 < n && dp[i + 1][j] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j]);
                }
                if (j - 1 >= 0 && dp[i][j - 1] > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
            for (int[] ints : dp) {
                System.out.println(Arrays.toString(ints));
            }
        }
        return maxLen;
    }
}
