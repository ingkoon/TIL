package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_12015_가장긴증가하는부분수열2 {
    static int n;
    static int[] arr;
    static int[] result;
    static int idx;

    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        arr = new int[n];
        result = new int[n];

        String[] tmp = bf.readLine().split(" ");
        for (int j = 0; j < tmp.length; j++)
            arr[j] = Integer.parseInt(tmp[j]);

        result[0] = arr[0];
        idx = 1;
        for (int i = 1; i < n; i++) {
            check(arr[i]);
        }
    }

    static void check(int num){
        int val = result[0];

        if(result[idx-1] < val){
            result[idx++] = val;
            return;
        }

        int size = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {
            int diff = result[i] - num;
            if(size > diff){
                size = result[i];
                idx = i;
            }
        }

    }
}