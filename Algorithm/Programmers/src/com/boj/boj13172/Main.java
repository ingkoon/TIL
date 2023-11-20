package com.boj.boj13172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m;
    static long MOD = 1000000007L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(bf.readLine());

        long result =0;

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int gcd = getGCD(Math.max(s, n), Math.min(s, n));

            n /= gcd;
            s /= gcd;

            result += s * getInverse(n, MOD-2) % MOD;
            result %= MOD;
        }
        System.out.println(result);
    }

    static int getGCD(int x, int y){ // 최대공약수를 구하는 메서드
        if(y == 0){
            return x;
        }
        return getGCD(y, x % y);
    }

    static long getInverse(long x, long y){
        if(y == 1)
            return x;
        long tmp = getInverse(x, y/2);
        long result = tmp * tmp % MOD;
        if(y % 2 == 1){
            result = result * x % MOD;
        }
        return result;
    }
}
