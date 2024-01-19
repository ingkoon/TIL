package com.boj.boj10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 10815 S5 숫자카드
 */
public class Main {
    static int n, m;
    static boolean[] cards;
    static int[] result, users;

    static int SIZE = 20_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        cards = new boolean[SIZE];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken()) + 10_000_000;
            cards[tmp] = true;
        }

        m = Integer.parseInt(bf.readLine());
        users = new int[m];
        st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < m; i++) {
            users[i] = Integer.parseInt(st.nextToken()) + 10_000_000;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if(cards[users[i]])
                sb.append(1);
            else
                sb.append(0);
            sb.append(" ");
        }

        System.out.println(sb);
    }
}
