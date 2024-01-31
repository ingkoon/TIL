package com.boj.boj2056;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[] costs;
    static int[] enters;
    static List<Integer>[] list;
    static int[] dp;
    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        list = new ArrayList[n+1];
        costs = new int[n+1];
        enters = new int[n+1];
        dp = new int[n+1];
        queue = new LinkedList<>();

        for (int i = 1; i <= n; i++)
            list[i] = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int cost = Integer.parseInt(st.nextToken());
            costs[i] = cost;
            dp[i] = cost;
            int cnt = Integer.parseInt(st.nextToken());
            enters[i] = cnt;
            for (int j = 0; j < cnt; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                list[tmp].add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            if(enters[i] == 0)
                queue.offer(i);
        }

        while (!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i < list[cur].size(); i++) {
                int next = list[cur].get(i);
                enters[next]--;
                dp[next] = Math.max(dp[cur] + costs[next], dp[next]);

                if(enters[next] == 0)
                    queue.offer(next);
            }
        }

        int result = 0;
        for (int sum : dp) {
            result = Math.max(result, sum);
        }
        System.out.println(result);
    }
}
