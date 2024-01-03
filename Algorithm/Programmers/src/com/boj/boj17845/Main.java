package com.boj.boj17845;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, k;
    static Study[] studies;
    static int[][] dp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        studies = new Study[k+1];
        dp = new int[k+1][n+1];

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(bf.readLine());
            int l = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            studies[i] = new Study(l, t);
        }

        for (int i = 1; i <= k; i++) {
            Study study = studies[i];
            for (int j = 1; j <= n; j++) {
                if(study.t <= j){
                    dp[i][j] = Math.max(study.l + dp[i - 1][j - study.t], dp[i - 1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[k][n]);
    }

    static class Study{
        int l;
        int t;

        public Study(int l, int t) {
            this.l = l;
            this.t = t;
        }
    }
}
