package com.boj.boj12931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] B;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        int result = 0;
        int max = 0;
        B = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp % 2 != 0){
                tmp--;
                B[i] = tmp;
                result += 1;
            }
            else{
                B[i] = tmp;
            }
            max = Math.max(max, tmp);
        }
        while ( max != 1){
            result++;
            max = max / 2;
        }
        result++;
        System.out.println(result);
    }
}
