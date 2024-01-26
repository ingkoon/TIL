package com.boj.boj1946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1946 S1 신입사원
 */
public class Main {
    static int T, n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(bf.readLine());
            List<Rank> ranks = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                ranks.add(new Rank(first, second));
            }

            ranks.sort(((o1, o2) -> o1.first - o2.first));
            int result = 1;
            int min = ranks.get(0).second;
            for (int i = 1; i < n; i++) {
                Rank rank = ranks.get(i);
                if(min > rank.second){
                    result++;
                    min = rank.second;
                }
            }

            System.out.println(result);
        }
    }
    static class Rank{
        int first;
        int second;

        public Rank(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
