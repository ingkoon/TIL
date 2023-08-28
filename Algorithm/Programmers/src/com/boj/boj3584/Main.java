package com.boj.boj3584;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//boj 3584 g4 가장 가까운 공통 조상
public class Main {
    static int T, N, result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(bf.readLine());

            List<Integer>[] board = new List[N+1]; // 배열 초기화
            for (int i = 0; i < N+1; i++) {
                board[i] = new ArrayList<>();
            }
            for (int i = 0; i < N-1; i++) { // 배열에 부모에 대한 정보값 추가
                StringTokenizer st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                board[b].add(a);
            }

            StringTokenizer st = new StringTokenizer(bf.readLine());

            int[] visited1 = new int[N+1];
            int[] visited2 = new int[N+1];

            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            bfs(board, visited1, num1, 1);
            bfs(board, visited2, num2, 1);

            int val = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < N; i++) {
                if(visited1[i] == 0 || visited2[i] ==0)
                    continue;
                int sum = visited1[i] + visited2[i];
                if(val > sum){
                    val = sum;
                    idx = i;
                }
            }
            System.out.println(idx);
        }
    }

    static void bfs(List<Integer>[] board, int[] visited, int x, int cnt){
        visited[x] = cnt;
        for(int i = 0; i < board[x].size(); i++){
            int num = board[x].get(i);
            if(visited[num] != 0)
                continue;
            bfs(board, visited, num, cnt+1);
        }
    }
}
/*
깊이 우선 탐색으로 상위 노드를 탐색하는 과정에서
공통으로 탐색되는 노드를 찾는다?

 */