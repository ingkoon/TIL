package com.boj.boj14567;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    static int[] enters;
    static int[] dp;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        enters = new int[n + 1];
        dp = new int[n + 1];
        queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[prev].add(next);
            enters[next]++;
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = 1;
            if(enters[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                dp[next] = Math.max(dp[cur] + 1, dp[next]);
                enters[next]--;
                if(enters[next] == 0)
                    queue.offer(next);
            }

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(dp[i]).append(" ");
        }

        System.out.println(sb);
    }
}
