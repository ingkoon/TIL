package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1806_부분합 {
    static int n, s;
    static int result = Integer.MAX_VALUE;
    static int[] arr;
    static int[] lenSize;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] st = bf.readLine().split(" ");
        n = Integer.parseInt(st[0]);
        s = Integer.parseInt(st[1]);

        arr = new int[n];

        st = bf.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st[i]);
        }
        Arrays.sort(arr);

        int end = 0;
        int sum = 0;
        for (int start = 0; start < n; start++) {
            while(sum < s && end < n){
                    sum += arr[end];
                    end++;
            }
            if(sum >= s) result = Math.min(result, end - start);
            sum -= arr[start];
        }
        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}
/*
10 10
10 1 1 1 1 1 1 1 1 1
 */