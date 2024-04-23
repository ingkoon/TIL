package com.boj.boj2876;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 2876 그래픽스 퀴즈
 */
public class Main {
    static int n;
    static int[][] students;
    static int[][] dp;
    static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        students = new int [n+1][2];
        dp = new int[n+1][2];
        cnt = new int[n+1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            students[i][0] = Integer.parseInt(st.nextToken());
            students[i][1] = Integer.parseInt(st.nextToken());

            dp[i][0] = 1;
            dp[i][1] = 1;
        }

        for(int i=1; i <= n; i++){
            if(students[i][0] == students[i-1][0])
                dp[i][0] = dp[i-1][0] + 1;
            else if(students[i][0] == students[i-1][1])
                dp[i][0] = dp[i-1][1] + 1;
            if(students[i][1] == students[i-1][0])
                dp[i][1] = dp[i-1][0] + 1;
            else if(students[i][1] == students[i-1][1])
                dp[i][1] = dp[i-1][1] + 1;
        }

        int grade = 0;
        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if(dp[i][0] > cnt){
                grade = students[i][0];
                cnt = dp[i][0];
            }else if(dp[i][0] == cnt){
                grade = Math.min(grade, students[i][0]);
            }

            if(dp[i][1] > cnt){
                grade = students[i][1];
                cnt = dp[i][1];
            }else if(dp[i][1] == cnt){
                grade = Math.min(grade, students[i][1]);
            }
        }

        System.out.println(cnt + " " + grade);
    }
}

/*
*/