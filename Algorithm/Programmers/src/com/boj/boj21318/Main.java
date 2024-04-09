package com.boj.boj21318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, q;
    static int[] input;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        input = new int[n + 1];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int cur = 0;

        for (int i = 1; i <= n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(cur > tmp){
                input[i] = input[i-1] + 1;
            }else{
                input[i] = input[i-1];
            }
            cur = tmp;
        }

        q =  Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(input[end] - input[start]).append("\n");
        }

        System.out.println(sb);
    }
}
