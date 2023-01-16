package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ_2251_물통 {

    static int[] bucket;
    static boolean[][] visited;

    static Set<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        bucket = new int[3];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = Integer.parseInt(st.nextToken());
        }

        result = new TreeSet<>();
        visited = new boolean[201][201];

        dfs(0, 0, bucket[2]);
        for (int r : result) {
            System.out.printf(r + " ");
        }
    }

    static void dfs(int a, int b, int c){
        if(visited[a][b]) return;

        if(a == 0){
            result.add(c);
        }
        visited[a][b] = true;
        if(a + b > bucket[1]){ // a에서 b로 물 이동
            dfs((a + b) - bucket[1], bucket[1], c);
        } else{
            dfs(0, a + b, c);
        }

        if(a + b > bucket[0]){ // b에서 a로 물 이동
            dfs(bucket[0], (a + b) - bucket[0], c);
        } else{
            dfs(a + b, 0, c);
        }

        if(a + c > bucket[0]){ // c에서 a로 물 이동
            dfs(bucket[0],b, a + c - bucket[0]);
        } else{
            dfs(a + c, b , 0);
        }

        if(b + c > bucket[1]) { // c에서 b로 물 이동
            dfs(a, bucket[1],b + c  - bucket[1] );
        }else{
            dfs(a, b + c, 0);
        }
        // a에서 c로 물 이동
        dfs(a, 0, b +c);
        // b에서 c로 물 이동
        dfs(0, b, a + c);
    }
}