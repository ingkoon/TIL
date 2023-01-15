package com.wanted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_신을모시는사당 {
    static int n;
    static int[] stones;
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        stones  = new int[n];
        result = new int[n][2];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
        }

        /*
        * 연속한 돌상에 색칠을 해야한다. | 왼쪽의 개수 - 오른쪽의 개수|
        * 그렇다면 첫번째 돌상부터 시작해서 하나 추가했을 때 더 큰 숫자가 될 수 있도록 해야한다?
        */
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = i; j < n; j++) {
                int now = stones[j];
                int val = now == 1 ? 1 : -1;
                if(i == j) { // 첫번째 숫자일 경우
                    tmp = val;
                    answer = Math.max(Math.abs(tmp), answer);
                    continue;
                }
               tmp = tmp + val;
               answer = Math.max(Math.abs(tmp), answer);
            }
        }

        System.out.println(answer);
    }
}
