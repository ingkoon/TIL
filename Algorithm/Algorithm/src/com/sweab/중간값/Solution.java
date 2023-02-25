package com.sweab.중간값;

import java.util.*;
import java.io.*;

class Solution {
    private static final int MOD = 20171109;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {

            PriorityQueue<Integer> minH = new PriorityQueue<>((i1, i2) -> i1 - i2);
            PriorityQueue<Integer> maxH = new PriorityQueue<>((i1, i2) -> i2 - i1);

            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            minH.add(A);
            int answer = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int num1 = Integer.parseInt(st.nextToken());
                int num2 = Integer.parseInt(st.nextToken());

                if (num1 > num2) {
                    minH.add(num1);
                    maxH.add(num2);
                } else {
                    minH.add(num2);
                    maxH.add(num1);
                }

                while (minH.peek() < maxH.peek()) {
                    int minVal = minH.poll();
                    int maxVal = maxH.poll();
                    minH.add(maxVal);
                    maxH.add(minVal);
                }
                answer = (minH.peek() + answer) % MOD;

            }

            System.out.println("#" + t + " " + answer);
        }

    }
}