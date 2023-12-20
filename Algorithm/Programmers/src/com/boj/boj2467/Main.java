package com.boj.boj2467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] solutions;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        solutions = new int[n];

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            solutions[i] = tmp;
        }

        int sum = Integer.MAX_VALUE;
        int[] result = new int[2];

        int left = 0;
        int right = n -1;

        while (left < right){
            int first = solutions[left];
            int second = solutions[right];
            int tmp = Math.abs(first + second);
            if(sum >= tmp){
                sum = tmp;
                result[0] = first;
                result[1] = second;
            }

            if(first + second < 0){
                left++;
            }else{
                right--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : result) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
