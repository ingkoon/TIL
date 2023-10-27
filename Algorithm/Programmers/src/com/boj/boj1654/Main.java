package com.boj.boj1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int k, n;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[k];

        long right = 0;
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(bf.readLine());
            arr[i] = tmp;
            right = Math.max(right, tmp);
        }

        if(n==1){
            System.out.println(right);
            return;
        }
        long left = 1;

        while (left < right){
            long mid = (left + right) / 2;
            long sum = 0;

            for (int i = 0; i < k; i++)
                sum += arr[i] / mid;

            if(sum >= n){
                left = mid + 1;
                continue;
            }
            right = mid - 1;
        }
        System.out.println((right + left) / 2);
    }
}
