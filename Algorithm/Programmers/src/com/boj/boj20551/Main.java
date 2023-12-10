package com.boj.boj20551;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(getLocation(arr, Integer.parseInt(bf.readLine()))).append("\n");
        }
        System.out.println(sb);
    }

    static int getLocation(int[] arr, int n){
        int result = -1;

        int start = 0;
        int end = arr.length;
        int mid = arr.length / 2;
        while (start < end){
            if(arr[mid] == n){
                result = mid;
            }
            if(n > arr[mid])
                start = mid + 1;
            else
                end = mid;
            mid = (start + end) / 2;
        }
        return result;
    }
}
