package com.boj.boj2133;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 2133 타일 채우기
 */
public class Main {
    static int n;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        init();
        int result = 0;
        if(isEven()) result = dp[n];
        System.out.println(result);
    }
    static void init(){
        dp = new int[31];
        dp[2] = 3;
        dp[4] = 11;
        for (int i = 6; i < 31; i+=2) {
            dp[i] = dp[i - 2] * 3;
            for (int j = 0; j < i - 2; j+=2) {
                dp[i] += dp[j] * 2;
            }
            dp[i] += 2;
        }
    }
    static boolean isEven(){
        return n % 2 == 0;
    }
}

/*
입력값을 통해 만들어지는 타일의 크기는 3 * n이다.
n이 1일 경우 -> x
n이 2일 경우 -> 3가지
n이 3일 경우 -> x
n이 4일 경우 -> 11개
n이 5일 경우 -> x

dp[2] = 3 = 2 + 1
dp[4] = 11 = dp[2] * dp[2] + 2
dp[6] = 41 = dp[4] * dp[2] + dp[2] * 2 + 2
dp[8] = dp[6] * dp[2] + dp[2] * 2 + 2 =
예를 들어 3 * 12이 주어졌을 때
1 2 3 4 5  6  7 8 9 10 11 12
0 3 0 11 0 12 0 18
 */