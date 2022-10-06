package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1194_달이차오른다가자 {
    static int n, m;
    static StringTokenizer st;

    static char[][] maze;
    static boolean[][][] visited;
    static int result;
    static int[] dr = {0 ,1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n][m];
        visited = new boolean[1<<7][n][m];

        int sR = 0;
        int sC = 0;
        for (int i = 0; i < n; i++) {
            char[] tmp = bf.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                maze[i][j] = tmp[j];
                if(maze[i][j] == '0') {
                    sR = i;
                    sC = j;
                }
            }
        }

        bfs(sR, sC);
    }

    private static void bfs(int r, int c) {
        Queue<Loc> queue = new LinkedList<>();
        queue.offer( new Loc(r, c, 0, 0));
        visited[0][r][c] = true;

        while(!queue.isEmpty()){
            Loc loc = queue.poll();
            int pr = loc.r;
            int pc = loc.c;
            int pCount = loc.count;
            int pLayer = loc.layer;
            if(maze[pr][pc] == '1') {
                System.out.println(pCount);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                int nLayer = pLayer;

                if(!isCheck(nr, nc)) continue;

                // 열쇠를 획득했을 경우 layer를 변화시킨다.
                if(maze[nr][nc] - 97 >= 0 && maze[nr][nc] - 97 < 6){
                    nLayer = pLayer | (1 << (maze[nr][nc] - 97));
                    // 문 조우시 layer를 낮춘다.
                }else if(maze[nr][nc] - 65 >= 0 && maze[nr][nc] - 65 < 6){
                    if((nLayer & (1<<(maze[nr][nc]-65))) != (1<<(maze[nr][nc]-65)))  continue;
                }

                if(visited[nLayer][nr][nc] || maze[nr][nc] == '#') continue;

                visited[nLayer][nr][nc] = true;
                queue.offer(new Loc(nr, nc, pCount+1, nLayer));
            }
        }
        System.out.println("-1");
    }

    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < n && 0<= nc && nc < m;
    }

    static class Loc{
        int r;
        int c;
        int count = 0;
        int layer = 0;

        public Loc(int r, int c, int count, int layer) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.layer = layer;
        }
    }
}