package com.boj.boj1644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n, SIZE = 4_000_001;
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        prime = new boolean[SIZE];
        prime[1] = true;
        for(int i = 2; i < SIZE; i++){
            if(!prime[i]){
                for (int j = i+i; j < SIZE; j+=i) {
                    prime[j] = true;
                }
            }
        }

        int left = 2;
        int right = 3;
        int result = 0;
        while(left < right){
            if(calc(left, right) == n){
                result++;
            }


            if(calc(left, right) < n){
                for (int i = right+1; i < SIZE; i++) {
                    if(!prime[i]){
                        right = i;
                        break;
                    }
                }
                continue;
            }

            for (int i = left + 1; i < SIZE; i++) {
                if(!prime[i]){
                    left = i;
                    break;
                }
            }
        }
        if(!prime[n]) result++;

        System.out.println(result);
    }

    static int calc(int left, int right){
        int result = 0;
        for (int i = left; i <= right; i++) {
            if(!prime[i])
                result += i;
        }

        return result;
    }
}
