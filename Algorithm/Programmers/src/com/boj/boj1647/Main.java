package com.boj.boj1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static Node[] roads;
    static int[] houses;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        roads = new Node[m];
        houses = new int[n+1];

        for (int i = 1; i <= n; i++) {
            houses[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            roads[i] = new Node(dep, des, cost);
        }

        Arrays.sort(roads, (o1, o2) -> o1.cost - o2.cost);
        int sum = 0;
        int max = 0;

        for (Node road : roads) {
            if (equalParent(road.dep, road.des))
                continue;
            union(road.dep, road.des);
            sum += road.cost;
            max = road.cost;

        }
        int result = sum - max;

        System.out.println(result);
    }

    static boolean equalParent(int x, int y){
        int parentX = find(x);
        int parentY = find(y);

        return parentX == parentY;
    }
    static void union(int x, int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootY != rootX)
            houses[rootY] = rootX;
    }

    static int find(int x){
        if(houses[x] == x)
            return x;

        return houses[x] = find(houses[x]);
    }
    
    public static class Node {
        int dep;
        int des;
        int cost;

        public Node(int dep, int des, int cost) {
            this.dep = dep;
            this.des = des;
            this.cost = cost;
        }
    }
}
