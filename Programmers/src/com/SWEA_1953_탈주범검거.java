package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_1953_탈주범검거 {

    static int T;
    static int n, m, r, c, l;
    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());

            map = new int[n][m];
            visited = new boolean[n][m];

            queue = new LinkedList<>();

            for(int i = 0; i< n; i++){
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            queue.offer(new int[]{r, c});
            // bfs 수행
            while(!queue.isEmpty()){
                if(cnt == l) break;
                cnt++;
                for (int i = 0; i < queue.size(); i++) {
                    int[] tmp = queue.poll();
                    int pr = tmp[0];
                    int pc = tmp[1];
                    visited[pr][pc] = true;
                    nextPipe(pr, pc);
                }

                for (int i = 0; i < n; i++) {
                    System.out.println(Arrays.toString(visited[i]));
                }
                System.out.println("-----------");
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j< m; j++){
                    if(visited[i][j]) result++;
                }
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }

    private static void nextPipe(int pr, int pc) {
        switch (map[pr][pc]){
            case 1:
                for (int i = 0; i < 4; i++) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!check(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 2:
                for (int i = 1; i < 4; i+=2) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!check(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 3:
                for (int i = 0; i < 3; i+=2) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!check(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 4:
                for (int i = 0; i < 2; i++) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!check(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 5:
                for (int i = 0; i < 4; i+=3) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!check(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 6:
                for (int i = 1; i < 3; i++) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!check(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 7:
                for (int i = 2; i < 4; i++) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!check(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    queue.offer(new int[] {nr, nc});
                }
                break;
        }
    }

    private static boolean check(int nr, int nc){
        return 0<= nr && nr < n && 0 <= nc && nc < m;
    }
}
/*
1
5 6 2 1 3
0 0 5 3 6 0
0 0 2 0 2 0
3 3 1 3 7 0
0 0 0 0 0 0
0 0 0 0 0 0
 */