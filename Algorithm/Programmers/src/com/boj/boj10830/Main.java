package com.boj.boj10830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

//boj 10830 행렬 제곱
public class Main {
    static int n;
    static long b;
    static long[][] proc;
    static long MOD = 1000L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        proc = new long[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                long num = Long.parseLong(st.nextToken()) % MOD;
                proc[i][j] = num;
            }
        }

        long[][] result = calc(proc, b);

        for (long[] num : result) {
            for (int i = 0; i < n; i++) {
                System.out.print(num[i] + " ");
            }
            System.out.println();
        }
    }

    static long[][]  calc(long[][] arr, long exp){
        if(exp == 1){
            return arr;
        }
        long[][] result = calc(arr, exp / 2);
        result = multiply(result, result);
        if(exp % 2 != 0){
            result = multiply(result, proc);
        }
        return result;
    }

    static long[][] multiply(long[][] o1, long[][] o2){
        long[][] result = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    result[i][j] += o1[i][k] * o2[k][j];
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }


}
