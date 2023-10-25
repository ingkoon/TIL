package com.boj.boj10816;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, SIZE = 10000000;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        arr = new int[SIZE * 2 + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken()) + SIZE;
            arr[tmp]++;
        }

        m = Integer.parseInt(bf.readLine());

        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            int tmp = Integer.parseInt(st.nextToken()) + SIZE;
            sb.append(arr[tmp]).append(" ");
        }
        System.out.println(sb);
    }
}
