package com.boj.boj1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
BOJ 1446 지름
 */
public class Main {
    static int n, d;
    static List<Road> list;
    static boolean[] visited;
    static int[] distance;
    static int MAX = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        Collections.sort(list, new Comparator<Road>() {
            @Override
            public int compare(Road r1, Road r2){
                if(r1.start == r2.start)
                    return r1.end - r2.end;
                return r1.start - r2.start;
            }
        });

        distance = new int[MAX];
        Arrays.fill(distance, MAX);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if(end > d || end - start < cost) continue;

            list.add(new Road(start, end, cost));
        }

        distance[0] = 0;
        System.out.println(dijkstra(0 ,0));
    }

    static int dijkstra(int idx, int move){
        while (move < d){
            if(idx < list.size()){
                Road r = list.get(idx);

                if(move == r.end){
                    distance[r.end] = Math.min(distance[move], distance[r.end] + r.cost);
                }
            }

        }
        int result =  distance[d];
        if(result == MAX){
            for(int i = d; i >= 0; i--){
                if(distance[i] != MAX){
                    result = Math.min(result, d - i + distance[i]);
                    break;
                }
            }
        }
        return result;
    }

    static class Road{
        int start;
        int end;
        int cost;

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
}
