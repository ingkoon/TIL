package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_18352_특정거리의도시찾기 {
    static int n, m, k, x;
    static boolean[] visited;

    static ArrayList<Integer>[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        //입력 부분
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        arr = new ArrayList[n+1];
        visited = new boolean[n+1];

        for (int i = 0; i < n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        // 2차원 List로 만들어 입력 수행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int from  = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from].add(to);
        }

        visited[x] = true;
        bfs();
    }

    private static void bfs() {
        // 현재의 깊이를 알기 위한 depth 변수 선언
        int depth = 0;

        // bfs사용과 오름차순으로 정렬하기 위한 queue선언
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        // 시작 도시 queue에 삽입
        queue.offer(x);

        // queue가 빌 때까지
        while (!queue.isEmpty()){
            //현재 depth = 도시간의 거리가 k일 경우
            if(depth==k) {
                break;
            }
            // 현재 queue에 있는 모든 도시를 가져다 거리 계산하기 위해 queue.size()호출
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int tmp = queue.poll();
                // 현재 도시를 방문했는지 확인 하며, 방문했을 경우 continue;
                // 아나라면 true표시를 하고 queue에 삽입
                for (int t : arr[tmp]) {
                    if(visited[t]) continue;
                    visited[t] = true;
                    queue.offer(t);
                }
            }
            // 한번 queue에 대해 순회를 마쳤다면 depth, 거리 증가
            depth++;
        }

        // queue가 비어있다면 -1 아니라면 현재 k만큼의 거리에 있는 요소들이 queue에 있으므로 순서대로 출력
        if(queue.isEmpty()) System.out.println(-1);
        else{
            for (Integer city : queue) {
                System.out.println(city);
            }
        }
    }
}

/*
3 1 1 1
1 3

5 5 1 2
1 2
2 3
3 4
4 5
5 1

4 4 2 1
1 3
1 2
2 4
2 3
 */
