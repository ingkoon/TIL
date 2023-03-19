package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_no2_이진수표현 {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            String result = "ON";
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if((m|(1<<n) -1) == m) result = "OFF"; // -1을 하는 이유는 연산자 우선순위로 10000-1 = 01111이되기 때문
            System.out.printf("#%d %s\n", t, result);
        }
    }
}
