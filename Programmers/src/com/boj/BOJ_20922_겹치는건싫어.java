package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20922_겹치는건싫어 {
    static int n, k;
    static int s, e;
    static int[] cntArray;
    static int[] arr;

    static int SIZE = 100001;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        // 원소가 k번 반복될 것인지 확인하기 위한 배열 선언
        cntArray = new int[SIZE];

        // 순서가 들어갈 배열 선언
        arr = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            cntArray[tmp]++;
            if(cntArray[tmp] > k){
                s = i;
                result = Math.max(result, cnt);
                cntArray = new int[SIZE];
                cntArray[i]++;
                cnt = 1;
                continue;
            }
            e++;
            cntArray[tmp]++;
            cnt++;
        }
        result = Math.max(result, cnt);
        System.out.println(result);
    }
}
