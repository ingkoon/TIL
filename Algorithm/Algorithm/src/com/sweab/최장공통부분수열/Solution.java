package com.sweab.최장공통부분수열;

import java.util.Scanner;

public class Solution {
    static int dp[][];

    public static void main(String[] args) {
        Scanner scann = new Scanner(System.in);
        int T = scann.nextInt();
        for (int testcase = 1; testcase <= T; testcase++) {
            String a = scann.next();
            String b = scann.next();

            dp = new int[a.length() + 1][b.length() + 1];
            for (int i = 1; i <= a.length(); i++) {
                for (int j = 1; j <= b.length(); j++) {
                    if (a.charAt(i - 1) == b.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }

            System.out.println("#" + testcase + " " + dp[a.length()][b.length()]);
        }
    }
}