package com.boj;

import java.util.*;

public class BOJ_5567_결혼식v2{
    static int n;
    static int len;
    static boolean[] visited;
    static int result;
    static int[][] arr;
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        len = sc.nextInt();
        visited = new boolean[n];
        arr = new int[n][n];

        for (int i = 0; i < len; i++) {
            int from = sc.nextInt()-1;
            int to = sc.nextInt()-1;
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        bfsV2();
        System.out.println(result);
    }

    private static void bfsV2(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(arr[0]);
        visited[0] = true;
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();

            for (int i = 0; i < n; i++) {
                if(tmp[i] == 0) continue;
                if(visited[i]) continue;
                result++;
                visited[i] = true;
                queue.offer(arr[i]);
            }
        }
    }
}