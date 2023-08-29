package com.boj.boj1949;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//boj 1949 우수 마을
public class Main {
    static int n;
    static int[] w;
    static int[][] dp;
    static List<Integer>[] list;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        w = new int[n+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 1; i <= n; i++)
            w[i] = Integer.parseInt(st.nextToken());

        list = new List[n+1];

        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();

        dp = new int[n+2][2];

        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1, 0);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    static void dfs(int num, int parent){
        for(int i = 0; i < list[num].size(); i++){
            int tmp = list[num].get(i);
            if(tmp != parent){
                dfs(tmp, num);
                dp[num][0] += Math.max(dp[tmp][0], dp[tmp][1]);
                dp[num][1] += dp[tmp][0];
            }
        }
        dp[num][1] += w[num];
    }
}
