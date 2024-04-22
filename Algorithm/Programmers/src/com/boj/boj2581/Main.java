package com.boj.boj2581;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * BOJ 2581 소수
 */
public class Main {
    static int m, n;
    static int SIZE = 10_001;
    static boolean[] nums;
    static int min = Integer.MAX_VALUE, result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(bf.readLine());
        n = Integer.parseInt(bf.readLine());
        nums = new boolean[SIZE];
        nums[0] = true;
        nums[1] = true;

        init();
        int result = calc(m, n);

        if(result == 0){
            System.out.println(-1);
        }else{
            System.out.println(result);
            System.out.println(min);
        }
    }

    static void init(){
        for(int i = 2; i <= Math.sqrt(n); i++){
            for(int j = i*2; j <= n; j += i){
                nums[j] = true;
            }
        }
    }

    static int calc(int m, int n){
        int result = 0;
        for(int i = m; i <= n; i++){
            if(!nums[i]){
                result+= i;
                min = Math.min(min, i);
            }
        }
        return result;
    }
}
