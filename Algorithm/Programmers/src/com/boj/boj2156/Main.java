package com.boj.boj2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] wines, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        wines = new int[n]; // 와인 배열 초기화
        dp = new int[n]; // dp 연산을 위한 배열 초기화

        for (int i = 0; i < n; i++)
            wines[i] = Integer.parseInt(bf.readLine()); // 와인 배열 값 할당

        dp[0] = wines[0];
        for(int i = 1; i < n; i++){
            if(i == 1){
                dp[1] = wines[0] + wines[1];
                continue;
            }
            if(i == 2){
                dp[2] = Math.max(dp[1],  Math.max(wines[0] + wines[2],wines[1] + wines[2])); // 초기값 세팅
                continue;
            }
            // 세개의 값을 비교한다.
            //
            dp[i] = Math.max(dp[i-1], Math.max(dp[i - 2] + wines[i], dp[i-3] + wines[i-1] + wines[i]));
            System.out.println(Arrays.toString(dp));
        }
        System.out.println(dp[n-1]);
    }
}
/*
* 연속해서 세잔을 마실 수 없다.
* */
