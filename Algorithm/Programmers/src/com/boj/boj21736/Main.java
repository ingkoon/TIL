package com.boj.boj21736;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static char[][] campus;
    static boolean[][] visited;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        campus = new char[n][m];
        visited = new boolean[n][m];

        int sr = 0;
        int sc = 0;
        for (int i = 0; i < n; i++) {
            String tmp = bf.readLine();
            for (int j = 0; j < m; j++) {
                campus[i][j] = tmp.charAt(j);
                if(tmp.charAt(j) == 'I'){
                    sr = i;
                    sc = j;
                }
            }
        }

        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(sr, sc));
        visited[sr][sc] = true;

        int result = 0;

        while(!queue.isEmpty()){
            Loc loc = queue.poll();
            if(campus[loc.r][loc.c] == 'P')
                result++;
            for (int i = 0; i < 4; i++) {
                int nr = loc.r + dr[i];
                int nc = loc.c + dc[i];
                if(!isCheck(nr, nc) || campus[nr][nc] == 'X' || visited[nr][nc])
                    continue;
                visited[nr][nc] = true;
                queue.offer(new Loc(nr, nc));
            }
        }
        if(result == 0){
            System.out.println("TT");
        }
        else{
            System.out.println(result);
        }
    }
    static boolean isCheck(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < m;
    }

    static class Loc{
        int r;
        int c;

        public Loc(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}