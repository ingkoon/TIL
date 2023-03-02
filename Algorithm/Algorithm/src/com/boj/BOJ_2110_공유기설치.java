package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2110_공유기설치 {
    static int n;
    static int c;
    static int[] houses;
    static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        houses = new int[n];
        for (int i = 0; i < n; i++) {
            houses[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(houses);

        install();
    }

    static void install(){
        int left = 1;
        int right = houses[n-1] - houses[0];
        int dis = 0;
        int result = 0;

        while (left <= right){
            int mid = (left + right) /2;
            int start = houses[0];
            int count = 1;
            for (int i = 0; i < n; i++) {
                dis = houses[i] - start;
                if(dis >= mid){
                    count++;
                    start = houses[i];
                }
            }
            if(count >= c){
                result = mid;
                left = mid + 1;
            } else{
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
