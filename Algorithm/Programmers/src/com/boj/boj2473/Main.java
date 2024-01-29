package com.boj.boj2473;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] arr;
    static long[] result;
    static long sum = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        arr = new long[n];
        result = new long[3];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);

        for (int i = 0; i < n-2; i++) {
            calc(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(result[0])
                .append(" ")
                .append(result[1])
                .append(" ")
                .append(result[2]);

        System.out.println(sb);
    }

    static void calc(int idx){
        int left = idx+1;
        int right = n-1;

        while(left < right){
            long tmpSum = arr[idx] + arr[left] + arr[right];
            long tmpResult = Math.abs(tmpSum);
            if(sum > tmpResult){
                result = new long[]{arr[idx], arr[left], arr[right]};
                result[0] = arr[idx];
                result[1] = arr[left];
                result[2] = arr[right];
                sum = tmpResult;
            }

           if(tmpSum > 0)
               right--;
           else
               left++;
        }
    }
}
/*
-2 -3 -24 -6 98 100 61
-24 -6 -3 -2 61 98 100
-24 -2 100

 */