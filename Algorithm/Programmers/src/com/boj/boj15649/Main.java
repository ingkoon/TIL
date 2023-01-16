package com.boj.boj15649;

import java.util.Scanner;

public class Main {
    static int[] nums;
    static boolean[] visited;
    static int[] result;
    static int n;
    static int p;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        p = sc.nextInt();

        nums = new int[n];
        visited = new boolean[n];

        result = new int[p];

        for (int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        dfs(0);
    }
    static void dfs(int cnt){
        if(cnt == p) {
            for (int i : result) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            result[cnt] =nums[i];
            dfs(cnt + 1);
            result[cnt] = 0;
            visited[i] = false;

        }
    }
}
