package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978_소수찾기 {
    static int n, result;
    static int[] arr;
    static int SIZE = 1001;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[SIZE];
        for (int i = 2; i < SIZE; i++) arr[i] = i;

        StringTokenizer st = new StringTokenizer(bf.readLine());


        for (int i = 2; i < SIZE; i++) {
            if(arr[i]==0) continue;

            for (int j = 2*i; j < SIZE; j+=i) {
                arr[j] = 0;
            }
        }

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(arr[tmp]!=0) result++;
        }
        System.out.println(result);
    }
}
