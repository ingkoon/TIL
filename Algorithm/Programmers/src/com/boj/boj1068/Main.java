package com.boj.boj1068;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static List<Integer>[] tree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        tree = new ArrayList[n];
        visited = new boolean[n];
        int start = 0;

        for (int i = 0; i < n; i++) 
            tree[i] = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp == -1){
                start = i;
                continue;
            }
            tree[tmp].add(i);
        }
        int deleteNumber = Integer.parseInt(bf.readLine());
        tree[deleteNumber] = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(tree[i].contains(deleteNumber)){
                tree[i].remove(tree[i].indexOf(deleteNumber));
            }
        }
        if(deleteNumber == start)
            System.out.println(0);
        else{
            dfs(start);
            System.out.println(result);
        }

    }

    static void dfs(int start){
        visited[start] = true;

        if(tree[start].size() == 0){
            result++;
            return;
        }

        for (int i = 0; i < tree[start].size(); i++) {
            int tmp = tree[start].get(i);
            if(visited[tmp])
                continue;
            dfs(tmp);
        }
    }

}
