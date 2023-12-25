package com.boj.boj9086;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            StringBuilder sb = new StringBuilder();
            char[] input = bf.readLine().toCharArray();
            sb.append(input[0]);
            sb.append(input[input.length-1]);
            System.out.println(sb);
        }
    }
}
