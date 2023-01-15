package com.boj;

import java.util.Scanner;

public class Solution_5607_조합 {
    static int T;
    static int n, r;
    static int MOD = 1234567891;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            n = sc.nextInt();
            r = sc.nextInt();

            long[] factorial = new long[n + 1];
            factorial[1] = 1;
            for (int i = 2; i <= n; i++) {
                factorial[i] = (factorial[i-1] * i) % MOD;
            }

            long result =  (factorial[r] * factorial[n - r]) % MOD;
            result = pow(result, MOD -2);

            System.out.printf("#%d %d", t, (factorial[n] * result) % MOD);
        }
    }
    private static long pow(long a, int b) {//a의 b승
        if(b == 0) return 1;
        else if(b == 1) return a;

        if(b % 2 == 0) {//b가 짝수인 경우
            long tmp = pow(a, b/2);
            return (tmp * tmp) % MOD;
        }

        long tmp = pow(a, b-1) % MOD;//pow(2,5) ==> pow(2,4)
        return (tmp * a) % MOD;
    }
}
