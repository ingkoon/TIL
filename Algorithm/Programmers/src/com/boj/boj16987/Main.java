package com.boj.boj16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 16987 계란으로 계란치
 */
public class Main {
    static int n, result;
    static Egg[] eggs;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        eggs = new Egg[n];
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int durability = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(durability, weight);
        }

        crashEgg(0, 0);
        System.out.println(result);
    }

    static void crashEgg(int idx, int cur){
        if(idx == n){
            result = Math.max(result, cur);
            return;
        }

        if(eggs[idx].durability <= 0 || cur == n-1){
            crashEgg(idx+1, cur);
            return;
        }

        for(int i = 0; i < n; i++){
            if(i == idx || eggs[i].durability <= 0)
                continue;
            int next = cur;
            crash(idx, i);
            if(eggs[idx].durability <= 0)
                next++;
            if(eggs[i].durability <= 0)
                next++;
            crashEgg(idx+1, next);
            recovery(idx, i);

        }

    }

    static void crash(int first, int second){
        eggs[first].durability -= eggs[second].weight;
        eggs[second].durability -= eggs[first].weight;
    }

    static void recovery(int first, int second){
        eggs[first].durability += eggs[second].weight;
        eggs[second].durability += eggs[first].weight;
    }

    static class Egg{
        int durability;
        int weight;

        public Egg(int durability, int weight) {
            this.durability = durability;
            this.weight = weight;
        }
    }
}
