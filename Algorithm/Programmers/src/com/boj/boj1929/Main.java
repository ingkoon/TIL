package com.boj.boj1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        bf.close();

        boolean[] isPrimeArr = new boolean[n+1];
        isPrimeArr[1] = true;

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            if(isPrimeArr[i])
                continue;
            if(i >= m)
                sb.append(i);
            for (int j = i + i; j <= n; j += i) {
                isPrimeArr[j] = true;
            }
        }
        System.out.println(sb);
    }


}
