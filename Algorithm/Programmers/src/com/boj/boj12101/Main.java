package com.boj.boj12101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 12101 1, 2, 3 더하기 2
 */
public class Main {
    static int n, k;
    static int idx;
    static int[] count;
    static String result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        count = new int[n];
        result = "-1";
        dfs(0, 0);
        System.out.println(result);
    }

    static void dfs(int cur, int num){
        if(num == n){
            idx++;
            if(idx == k){
                StringBuilder sb = new StringBuilder();
                for (int i : count) {
                    if(i == 0)
                        break;
                    sb.append(i).append('+');
                }
                sb.deleteCharAt(sb.length()-1);
                result = sb.toString();
            }
            return;
        }

        for (int i = 1; i <= 3; i++) {
            if(num + i > n)
                continue;
            count[cur] = i;
            dfs(cur + 1, num + i);
            count[cur] = 0;
        }
    }
}
