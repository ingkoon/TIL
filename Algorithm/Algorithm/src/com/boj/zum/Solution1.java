package com.boj.zum;

public class Solution1 {
    public static void main(String[] args) {
        long n = 2;
        System.out.println(solution(n));
    }
    static long solution(long n){
        long val = n+1;
        long size = n-1;
        // 등차수열의 합

        return size * (val + (val * size)) / 2;
    }
}
