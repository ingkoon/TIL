package com.boj.boj14912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 14912 숫자 빈도수
 */
public class Main {
    static int n, d;
    static int[] freq;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        freq = new int[10];

        for (int i = 1; i <= n; i++) {
            char[] tmp = String.valueOf(i).toCharArray();
            for (char c : tmp) {
                freq[c-'0']++;
            }
        }
        System.out.println(freq[d]);
    }
}
