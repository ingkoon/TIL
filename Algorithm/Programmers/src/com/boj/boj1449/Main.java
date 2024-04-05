package com.boj.boj1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 1449 수리공 항승
 */
public class Main {
    static int n, l;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int idx = arr[0];
        int length = l-1;
        int result = 1;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - idx <= length){
                length = length - (arr[i] - idx);
                idx = arr[i];
            }else{
                idx = arr[i];
                length = l-1;
                result++;
            }
        }

        System.out.println(result);
    }
}

/**
 * for문을 순회하면서 현재 위치가 가장많은 값을 가져갈 수 있으면 적용한다?
 */
