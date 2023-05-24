package com.swea.동아리실관리하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_no3_동아리실관리하기 {
    static int T,n;
    static char[] input;
    static int r = 3;
    static boolean[] visited;
    static int result;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            String tmp = bf.readLine();
            input = tmp.toCharArray();
            n = input.length;
            result = 0;
            for (char i : input) {
                visited = new boolean[4];
                int idx = i - 65;
                nPr(idx, 0);
            }
            System.out.printf("#%d %d", t, result);
        }
    }

    static void nPr(int idx, int cnt){
        if(cnt == r){
            if(!visited[idx]){
                return;
            }
            result++;
        }
        for (int i = 0; i < 4; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            nPr(idx, cnt+1);
            visited[i] = false;
        }
    }
}
