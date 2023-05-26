package com.boj.BOJ_1629_곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(recur(A, B));
    }

    static long recur(int a, int b){
        if(b == 1) return a % C;

        long tmp = recur(a, b / 2);


        if(b%2 == 1){
            return (tmp * tmp) % C * a % C;
        }
        return (tmp * tmp) % C;
    }
}

/*
b가 홀수

 */
