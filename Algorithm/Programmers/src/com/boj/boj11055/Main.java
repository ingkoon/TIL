package com.boj.boj11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 11055 가장 큰 증가하는 부분 수열
 */
public class Main {
    static int n;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        input = new int[n+1];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            input[i] = Integer.parseInt(st.nextToken());
        }
    }
}
