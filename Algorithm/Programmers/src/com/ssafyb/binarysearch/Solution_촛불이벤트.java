package com.ssafyb.binarysearch;

import java.util.Scanner;

class Solution_촛불이벤트 {
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

            long N = sc.nextLong();

            long L = 1;
            long R = 10000000000L;
            long res = 0;
            while(L <= R) {
                long mid = (L + R) / 2;
                long value = mid * (mid + 1) / 2;

                if(N >= value) {
                    res = mid;
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }

            long value = res * (res + 1) / 2;
            if(N != value) {
                res = -1;
            }
            System.out.printf("#%d %d\n", test_case, res);

        }
    }
}