package com.boj;

import java.util.Scanner;

public class BOJ_20546_기적의매매법 {
    static int n, jCredit, sCredit;
    static int DAY = 14;
    static int[] prices;
    static int[] jh;
    static int[] sm;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        jCredit = n;
        sCredit = n;
        prices = new int[DAY];
        jh = new int[DAY];
        sm = new int[DAY];

        for (int i = 0; i < DAY; i++) {
            prices[i] = sc.nextInt();
        }

        doBnp();
        doTiming();
    }

    // 성민이의 매매법
    private static void doTiming() {
        int upCnt = 0;
        int downCnt = 0;

        for (int i = 1; i < DAY; i++) {
            if(prices[i] > prices[i-1]){
                upCnt ++;
                downCnt = 0;
            }
            else if(prices[i] < prices[i-1]){
                downCnt ++;
                upCnt = 0;
            }

            
        }

    }

    // 준현이의 매매법
    private static void doBnp() {
        for (int i = 0; i < DAY; i++) {
            int tmp = jCredit / prices[i]; // 몫에 대한 임시값을 저장한다.
            jh[i] = tmp; // 최대 주 저장
            jCredit = jCredit % prices[i]; // 주식을 구매한 나머지 금액 반환
        }
    }
}
