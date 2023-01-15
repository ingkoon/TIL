package com.wanted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A_신을모시는사당V2 {
    static int n;
    static int[] stones;
    static int[] tmp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        stones = new int[n];
        tmp = new int[n];
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
            int now = stones[i];
            int val = now == 1 ? 1 : -1;
            if(i == 0) {
                tmp[0] = Math.abs(val);
                continue;
            }
            tmp[i] = tmp[i-1]+ val;
        }

        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, Math.abs(tmp[i]));

        }

        System.out.println(answer);
    }
}
