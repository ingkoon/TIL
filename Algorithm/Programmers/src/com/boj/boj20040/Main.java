package com.boj.boj20040;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] parents;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n];
        for (int i = 0; i < n; i++)
            parents[i] = i;

        int result = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int dep = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());

            if(find(dep) != find(des)){
                union(dep, des);
            }else {
                result = i+1;
                break;
            }
        }
        System.out.println(result);
    }

    static int find(int x){
        if(parents[x] == x)
            return x;
        return parents[x] = find(parents[x]);
    }

    static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y)
            parents[y] = x;
    }
}
