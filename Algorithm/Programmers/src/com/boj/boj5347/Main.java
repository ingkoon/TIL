package com.boj.boj5347;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static long a, b;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            long[] inputs = new long[2];
            inputs[0] = Long.parseLong(st.nextToken());
            inputs[1] = Long.parseLong(st.nextToken());

            Arrays.sort(inputs);
            a = inputs[0];
            b = inputs[1];

            System.out.println(lcm(a, b));
        }
    }

    static long gcd(long a, long b){
        if(a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b){
        long gcd = gcd(a, b);
        return  (a * b) / gcd;
    }
}
