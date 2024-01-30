package com.boj.boj1005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T, n, k;

    static int[] costs;
    static int[] enters;
    static int[] dp;

    static boolean[] visited;
    static Queue<Integer> queue;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            costs = new int[n+1]; // 건설 시간 초기화
            queue = new LinkedList<>();
            list = new ArrayList[n+1];
            enters = new int[n+1];
            dp = new int[n+1];
            visited = new boolean[n+1];

            st = new StringTokenizer(bf.readLine());

            for (int i = 1; i <= n; i++) { // 배열 초기화 및 건설 시간 할당
                int tmp = Integer.parseInt(st.nextToken());
                costs[i] = tmp;
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < k; i++) { // 리스트에 다음 건설 요소 저장
                st = new StringTokenizer(bf.readLine());
                int dep = Integer.parseInt(st.nextToken());
                int des = Integer.parseInt(st.nextToken());
                list[dep].add(des);
                enters[des]++;
            }

            for(int i = 1; i <= n; i++)
                dp[i] = costs[i];

            int target = Integer.parseInt(bf.readLine());
            int result = calc(target);
            System.out.println(result);
        }
    }

    static void findZero(){ // 진입 차수가 0인 건물 확인
        for (int i = 1; i <= n; i++) {
            if(enters[i] == 0 && !visited[i]){
               queue.offer(i);
               visited[i] = true;
            }
        }
    }

    static void reduceEnter(int idx){
        for (int i = 0; i < list[idx].size(); i++) {
            int next = list[idx].get(i);
            enters[next]--;
            dp[next] = Math.max(dp[idx] + costs[next], dp[next]);
        }
    }

    static int calc(int target){
        int result = 0;
        findZero();

        while (!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == target){
                break;
            }
            reduceEnter(cur);
            findZero();
        }
        result = dp[target];
        return result;
    }
}
/*
모든 진입차수가 0인 건물을 가져온다.
queue를 모두 비우며 각 턴의 가장 큰 비용을 가져온다.
1
6 6
10 5 1 1 9 8
1 2
1 4
2 3
4 5
3 6
5 6
6
 */
