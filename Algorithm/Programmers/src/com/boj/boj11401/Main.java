package com.boj.boj11401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* BOJ 11401 이항계수 3
*/
public class Main {
    static int n, k;
    static long result;
    static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        long first = factorial(n);
        long second = factorial(k) * factorial(n-k) % MOD;
        result = first * pow(second, MOD - 2) % MOD;
        System.out.println(result);
    }
    static long factorial(int num){
        long tmp = 1L;
        while(num > 0)
            tmp *= num--;

        return tmp;
    }

    static long pow(long num, long exp){
        if(exp == 1)
            return num % MOD;
        long tmp = pow(num, exp/2);
        if(exp%2 ==1 )
            return (tmp * tmp % MOD) * num % MOD;
        return tmp * tmp % MOD;
    }
}
