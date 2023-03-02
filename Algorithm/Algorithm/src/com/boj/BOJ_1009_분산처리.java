package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1009_분산처리 {
    static int a, b, t;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(bf.readLine());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(bf.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a % 10 == 0) {
                System.out.println(10);
                continue;
            }

            int result = a % 10;
            for (int j = 1; j < b; j++) {
                result = (result * a) % 10;
            }
            System.out.println(result);

        }
    }
}
