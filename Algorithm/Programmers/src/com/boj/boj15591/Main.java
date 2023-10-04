package com.boj.boj15591;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
boj 15591 Mootube
 */
public class Main {
    static int n, q;
    static List<Video>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        graph = new List[n+1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int usado = Integer.parseInt(st.nextToken());

           graph[dep].add(new Video(des, usado));
           graph[des].add(new Video(dep, usado));
        }
        for (int i = 0; i < q; i++) {
            visited = new boolean[n+1];
            st = new StringTokenizer(bf.readLine());
            int k = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            System.out.println(dfs(start, k));
        }
    }

    static int dfs(int start, int limit){
        int result = 0;
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for (int i = 0; i< graph[cur].size(); i++) {
                Video video = graph[cur].get(i);
                if(video.usado < limit || visited[video.num])
                    continue;
                result++;
                visited[video.num] = true;
                queue.offer(video.num);
            }
        }
        return result;
    }

    static class Video {
        int num;
        int usado;

        public Video(int num, int usado) {
            this.num = num;
            this.usado = usado;
        }
    }
}

