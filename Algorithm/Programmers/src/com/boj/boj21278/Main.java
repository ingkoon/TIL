package com.boj.boj21278;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 21278 호석이 두 마리 치킨
 */
public class Main {
    static int n, m;
    static final int INF = 10001;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());

            int dep = Integer.parseInt(st.nextToken());
            int des = Integer.parseInt(st.nextToken());

            dist[dep][des] = 1;
            dist[des][dep] = 1;
        }

        int[] pick = new int[2];
        int sum = INF;

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int tmp = 0;
                for (int k = 1; k <= n; k++) {
                    if(i==k || j == k)
                        continue;
                    tmp+= (Math.min(dist[i][k],dist[j][k]) * 2);
                }

                if(sum > tmp){
                    sum = tmp;
                    pick[0] = i;
                    pick[1] = j;
                }
            }
        }

        Arrays.sort(pick);
        System.out.println(pick[0] + " " + pick[1] + " " + sum);
    }
}
