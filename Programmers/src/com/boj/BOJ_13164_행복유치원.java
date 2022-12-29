package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13164_행복유치원 {
    static int n, k;
    static int[] group;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        group = new int[n];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            group[i] = Integer.parseInt(st.nextToken());
        }
        div();
        System.out.println(result);
    }

    static void div(){
        int tmp = n / k + 1; // 홀수일 경우
        if(n%2 == 0) tmp = n / k; // 짝수일 경우
        int s = 0;
        int e = tmp;;
//        System.out.println(group[s] + " " + group[e-1]);
        while(e < n){
            result += group[e-1] - group[s];
            s = e;
            e += tmp;
        }
        if(e - tmp != n -1){
            result += group[n-1] - group[e - tmp];
        }
    }
}
