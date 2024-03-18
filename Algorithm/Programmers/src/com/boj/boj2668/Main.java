package com.boj.boj2668;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int n, result;
    static int[][] table;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        table = new int[n+1][n+1];
        sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            table[0][i] = i;
            table[1][i] = Integer.parseInt(bf.readLine());
        }

        for (int i = 1; i <= n; i++)
            if(bfs(i)){
                result++;
                sb.append(i).append("\n");
            }

        System.out.println(result);
        System.out.println(sb);
    }

    static boolean bfs(int start){

        boolean[] visited = new boolean[n+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start, table[1][start]});

        boolean flag = false;

        while (!queue.isEmpty()){ //
            int[] cur = queue.poll();
            int val = cur[1];
            if(start == val){
                flag = true;
                break;
            }
            if(visited[val])
                continue;
            visited[val] = true;
            int idx = val;
            val = table[1][idx];
            queue.offer(new int[] {idx, val});
        }

        return flag;
    }
}

/*
7
4
1
1
5
3
4
5

1 2 3 4 5 6 7
4 1 1 5 3 4 5

ans 1 3 4 5
 */
