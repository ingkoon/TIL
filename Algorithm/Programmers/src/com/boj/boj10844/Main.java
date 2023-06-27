package com.boj.boj10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // boj 10844 쉬운계단수
    static int n;
    static int result;
    static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
    }
}

/*
1 = 9;
2 = 17;
3 = 32; 34 - 2
4 = 61; 64 - 3
5 = 116; 122 - 6
6 = 222; 232 - 10
 */