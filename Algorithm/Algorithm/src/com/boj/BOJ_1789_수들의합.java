package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1789_수들의합 {
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(bf.readLine());

        long sum = 0;
        long result = 0;

        for (long i = 1; i<n+1; i++) {
            if(sum > n) break;
            sum += i;
            result++;
        }

        System.out.println(result-1);
    }
}
