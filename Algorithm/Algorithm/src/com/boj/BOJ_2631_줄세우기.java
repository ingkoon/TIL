package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2631_줄세우기 {
    static int n, result;
    static int[] arr;
    static int[] lis;
    static int searchBinary(int left, int right, int val){
        if(left >= right)
            return right;

        int mid = (left + right) /2;
        if(arr[left] < val){
            left = mid + 1;
            return searchBinary(left, right, val);
        }
        right = mid;
        return searchBinary(left, right, val);
    }

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        lis = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }
        lis[0] = arr[0];
        int j = 0;
        int cnt = 1;
        for (int i = 0; i < n; i++) {
            if(lis[j] < arr[i]){
                lis[j+1] = arr[i];
                j += 1;
                cnt++;
                continue;
            }
            int idx = searchBinary(0, j, arr[i]);
            lis[idx] = arr[i];
        }
        result = n - cnt;
        System.out.println(result);
    }
}
