package com.boj.boj1271;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    static BigInteger n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = new BigInteger(st.nextToken());
        m = new BigInteger(st.nextToken());

        BigInteger[] result = n.divideAndRemainder(m);

        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
