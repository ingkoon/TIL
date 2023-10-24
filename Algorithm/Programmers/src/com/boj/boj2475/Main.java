package com.boj.boj2475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int result = 0;

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(st.nextToken());
            result += num * num;
        }
        System.out.println(result%10);
    }
}
