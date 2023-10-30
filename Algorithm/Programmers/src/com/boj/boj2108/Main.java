package com.boj.boj2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * boj 2108 s3 통계학
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        int sum = 0; // 산술 평균을 구하기 위한 수의 합 변수
        int[] mid = new int [n]; // 중앙갑 구하기 위한 변수
        int[] arr = new int[10000]; // 최빈값
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE; // 범위 구한다.

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(bf.readLine());
            sum += tmp;
            mid[i] = tmp;
            arr[tmp + 4000]++;
            max = Math.max(max, tmp);
            min = Math.min(min, tmp);
         }

        StringBuilder sb = new StringBuilder();

        sb.append(Math.round((float)sum / (float)n)).append("\n");

        Arrays.sort(mid);
        sb.append(mid[n/2]).append("\n");

        int maxCnt = 0;

        int cntVal = 0;
        boolean flag = false;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > maxCnt){
                flag = false;
                maxCnt = arr[i];
                cntVal = i - 4000;
            }
            else if(arr[i] == maxCnt){
                if(flag) continue;
                cntVal = i - 4000;
                flag = true;
            }
        }

        sb.append(cntVal).append("\n");
        sb.append(max - min);

        System.out.println(sb);
    }
}
