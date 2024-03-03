package com.boj.boj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[][] room;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine()); // 방 배열 초기화
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        visited = new boolean[n][m];

        st = new StringTokenizer(bf.readLine()); // 로봇 청소기 위치 및 방향 초기화
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        RobotVacuums rv = new RobotVacuums(r,c,dir);

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clean(rv);
        System.out.println(result);
    }

    static void clean(RobotVacuums rv){
        while(true){
            if(!visited[rv.r][rv.c])result++;
            visited[rv.r][rv.c] = true;

            if(!isBlank(rv)){
                int br = rv.r - dr[rv.dir];
                int bc = rv.c - dc[rv.dir];
                if(room[br][bc] == 1)
                    break;
                rv.back();
                continue;
            }

            rv.turn();

            int nr = rv.r+dr[rv.dir];
            int nc = rv.c+dc[rv.dir];

            if(room[nr][nc] == 0 && !visited[nr][nc]){
                rv.r = nr;
                rv.c = nc;
            }
        }
    }

    static boolean isBlank(RobotVacuums rv){
        for (int i = 0; i < 4; i++) {
            int nr = rv.r + dr[i];
            int nc = rv.c + dc[i];
            if(room[nr][nc] == 0 && !visited[nr][nc])
                return true;
        }
        return false;
    }
    static class RobotVacuums{
        int r;
        int c;
        int dir;
        public RobotVacuums(int r, int c, int dir) {
            this.r = r;
            this.c = c;
            this.dir = dir;
        }

        public void turn(){
            dir = dir == 0 ? 3 : dir - 1;
        }

        public void back(){
            r = r - dr[dir];
            c = c - dc[dir];
        }
    }
}
