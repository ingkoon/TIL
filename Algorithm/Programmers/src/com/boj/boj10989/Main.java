package com.boj.boj10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] list = new int[10001];

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(bf.readLine());
            list[tmp]++;
        }

        bf.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= 10000; i++) {
            if(list[i] == 0)
                continue;
            for (int j = 0; j < list[i]; j++) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }
}
