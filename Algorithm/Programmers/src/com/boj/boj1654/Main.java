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

        int num = 0;
        int max = 0;
        for (int i = 0; i < k; i++) {
            int tmp = Integer.parseInt(bf.readLine());
            num += tmp;
            arr[i] = tmp;
            max = Math.max(max, tmp);
        }

        num /= n;
        if(n==1){
            System.out.println(max);
        }
        else{
            for(int i = num; i >= 1; i--){
                int cnt = 0;
                for (int j = 0; j < k; j++) {
                    cnt += arr[j] / i;
                }
                if(cnt >= n){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
