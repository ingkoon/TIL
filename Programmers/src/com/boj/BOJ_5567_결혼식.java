package com.boj;

import java.util.*;

public class BOJ_5567_결혼식 {
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

//        dfs(0);
//        bfsV2();
        System.out.println(result);
    }

    private static void dfs(int cnt) {
        visited[cnt] = true;
        List<Integer> tmp = arr.get(cnt);
        for (int i = 0; i < tmp.size(); i++) {
            int p = tmp.get(i);
            if(visited[i]) continue;
            result++;
            dfs(p);
        }
    }
    private static void bfs(int cnt){
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.offer(arr.get(cnt));
        visited[cnt] = true;
        while(!queue.isEmpty()){
            List<Integer> tmp = queue.poll();
            for (Integer t : tmp) {
                if(visited[t]) continue;
                result++;
                visited[t] = true;
                queue.offer(arr.get(t));
            }
        }
    }

    private static void bfsV2(){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            List<Integer> tmp = arr.get(queue.poll());
            for (Integer t : tmp) {
                if(visited[t]) continue;
                result++;
                visited[t] = true;
                queue.offer(t);
            }
        }
    }
}
