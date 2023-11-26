package com.boj.boj16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static int[] board;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[101];
        visited = new boolean[101];

        for (int i = 0; i < n+m; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            board[start] = end;
        }


        Queue<Loc> queue = new LinkedList<>();

        queue.offer(new Loc(1, 0));
        visited[1] = true;
        while (!queue.isEmpty()){
            Loc loc = queue.poll();
            if(loc.loc == 100){
                System.out.println(loc.cnt);
                break;
            }

            for (int i = 1; i <= 6; i++) {
                int nLoc = loc.loc + i;
                if(nLoc > 100 || visited[nLoc])
                    continue;
                visited[nLoc] =true;
                if(board[nLoc] == 0){
                    queue.offer(new Loc(loc.loc + i, loc.cnt + 1));
                }else{
                    visited[board[nLoc]] =true;
                    queue.offer(new Loc(board[nLoc], loc.cnt+1));
                }
            }
        }
    }

    static class Loc{
        int loc;
        int cnt;
        public Loc(int loc, int cnt) {
            this.loc = loc;
            this.cnt = cnt;
        }
    }
}
