package com.boj.boj2565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;

    static Link[] links;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        links = new Link[n];
        dp = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            links[i] = new Link(a, b);
        }

        Arrays.sort(links);

        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, recur(i));
        }

        result = n - result;
        System.out.println(result);
    }

    static int recur(int idx){
        if(dp[idx] == 0){
            dp[idx] = 1;
            for (int i = idx+1; i < n; i++) {
                if(links[idx].b < links[i].b){
                    dp[idx] = Math.max(dp[idx], recur(i)+1);

                }
            }
        }
        return dp[idx];
    }

    static class Link implements Comparable<Link>{
        int a;
        int b;

        public Link(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Link o) {
            return this.a - o.a;
        }
    }
}
