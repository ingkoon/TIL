package com.boj.boj12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ G2 12015 가장 긴 증가하는 부분 수열 2
 */
public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        int[] seq = new int[n];
        int[] lis = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        lis[0] = seq[0];
        int lisSize = 1;

        for (int i = 1; i < n; i++) {
            int key = seq[i];

            if(lis[lisSize - 1] < key ){
                lis[lisSize] = key;
                lisSize++;
                continue;
            }

            int lo = 0;
            int hi = lisSize;

            while (lo < hi){
                int mid = (lo + hi) / 2;
                if(lis[mid] < key){
                    lo = mid + 1;
                }else{
                    hi = mid;
                }
            }

            lis[lo] = key;
        }
        System.out.println(lisSize);
    }
}
