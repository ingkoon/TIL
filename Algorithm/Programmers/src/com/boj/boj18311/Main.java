package com.boj.boj18311;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 18311 왕복
 */
public class Main {
    static int n;
    static long k;
    static int[] courses;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(bf.readLine());

        courses = new int[n+1];

        for (int i = 1; i <= n; i++)
            courses[i] = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= n; i++){
            k -= courses[i];
            if(k < 0){
                result = i;
                break;
            }
        }

        if(result == 0){
            for (int i = n; i >= 1; i--) {
                k -= courses[i];
                if(k < 0){
                    result = i;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}
