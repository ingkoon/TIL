package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2011_암호코드 {
    static String n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = bf.readLine();

        int[] dp = new int[n.length()+1];
        dp[0] = 1;

        for (int i = 1; i <= n.length(); i++) {
            int num1 = n.charAt(i-1) - '0';
            if(num1 >= 1 && num1<=9){
                dp[i] += dp[i-1];
                dp[i] %= 100000000;
            }
            if(i == 1) continue;

            int num2 = n.charAt(i-2) -'0';
            if(num2 == 0) continue;
            int ten = num2 * 10 + num1;

            if(ten >= 10 && ten < 26){
                dp[i] += dp[i-2];
                dp[i] %= 100000000;
            }
        }
        System.out.println(dp[n.length()]);
    }
}
