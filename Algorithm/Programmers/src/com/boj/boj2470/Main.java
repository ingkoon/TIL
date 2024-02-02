package com.boj.boj2470;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * BOJ 2470 G5 두 용액
 */
public class Main {
    static int n;
    static long sum= Long.MAX_VALUE;
    static long[] board;
    static long[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        board = new long[n];
        result = new long[2];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++)
            board[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(board);

        int left = 0;
        int right = n-1;

        while (left < right){
            long tmp = board[left] + board[right];
            long absTmp = Math.abs(tmp);
            if(sum > absTmp){
                sum = absTmp;
                result[0] = board[left];
                result[1] = board[right];
            }

            if(tmp < 0)
                left++;
            else
                right--;
        }

        System.out.println(result[0] + " " + result[1]);
    }
}
