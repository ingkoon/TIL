package com.boj;

import java.util.*;

public class BOJ_5567_결혼식v3 {
    static int n;
    static int len;
    static boolean[] visited;
    static int result;
    static List<ArrayList<Integer>> arr;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        len = sc.nextInt();
        visited = new boolean[n];
        arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            int from = sc.nextInt()-1;
            int to = sc.nextInt()-1;
            arr.get(from).add(to);
            arr.get(to).add(from);
        }

        visited[0] = true;
//        dfs(0);
        dfs(0,0);
        System.out.println(Arrays.toString(visited));
        System.out.println(result);
    }

    private static void dfs(int cnt, int depth) {
        if(depth > 2) {
            return;
        }
        List<Integer> tmp = arr.get(cnt);
        for(int p : tmp){
            if(visited[p]) continue;
            result++;
            visited[p] = true;
            dfs(p, depth+1);
        }
//        for (int i = 0; i < tmp.size(); i++) {
//            int p = tmp.get(i);
//            if(visited[p]) continue;
//            result++;
//            visited[p] = true;
//            dfs(p, depth+1);
//        }
    }

}


