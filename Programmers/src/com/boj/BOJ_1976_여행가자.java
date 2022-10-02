package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1976_여행가자 {
    static int n, m;

    static int[] p;
    static int[] r;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        makeSet();


        for (int i = 1; i < n; i++) {
             st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < m; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                if(tmp == 1){
                    union(i,j);
                }
            }
        }

        st = new StringTokenizer(bf.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < m; i++) {
            int now = Integer.parseInt(st.nextToken());

            // 맨 처음 출발 도시와 연결되어있지 않은 도시가 있으면
            // 여행 계획이 불가능한 것임.
            if (start != find(now)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static boolean union(int x, int y){
        x = find(x);
        y = find(y);
        if(x==y) return false;
        if(r[x] < r[y]){
            r[y] += r[x];
            p[x] = y;
        } else{
            r[x] +=r[y];
            p[y] = x;
        }
        return true;
    }

    public static int find(int x){
        if(x == p[x]) return x;
        else return p[x] = find(p[x]);
    }

    // 배열 초기화 과정
    static void makeSet(){
        p = new int[n+1];
        for (int i = 1; i < n; i++) {
            p[i] = i;
        }

        r = new int[n+1];
        for (int i = 0; i < n; i++) {
            r[i] = 1;
        }
    }
}
