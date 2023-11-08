package com.boj.boj20529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int T, n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for(int t = 0; t < T; t++) {
            n = Integer.parseInt(bf.readLine());
            if(n > 32) { // 3명이 겹치는 경우이므로
                System.out.println(0);
                bf.readLine();
                continue;
            }
            String[] arr = bf.readLine().split(" ");
            int result = getDistance(arr);
            System.out.println(result);
        }
    }

    static int getDistance(String[] arr){
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-2; i++) {
            String a = arr[i];
            for (int j = i+1; j < arr.length - 1; j++) {
                String b = arr[j];
                for (int k = j+1; k < arr.length; k++) {
                    String c = arr[k];

                    int cnt = 0;
                    cnt += calcDistance(a, b);
                    cnt += calcDistance(b, c);
                    cnt += calcDistance(a, c);
                    result = Math.min(result, cnt);
                }
            }
        }
        return result;
    }

    static int calcDistance(String x, String y){
        char[] arrX = x.toCharArray();
        char[] arrY = y.toCharArray();
        int result = 0;
        for (int i = 0; i < 4; i++) {
            result += arrX[i] != arrY[i] ? 1 : 0;
        }

        return  result;
    }
}