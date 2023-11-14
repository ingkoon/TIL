package com.boj.boj9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        char[] input1 = bf.readLine().toCharArray();
        char[] input2 = bf.readLine().toCharArray();

        int n = input1.length;
        int m = input2.length;

        int[][] lcs = new int[n+1][m+1];

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                if(input1[i-1] == input2[j-1]) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                }
                else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        int result = lcs[n][m];

        System.out.println(result);
    }
}
