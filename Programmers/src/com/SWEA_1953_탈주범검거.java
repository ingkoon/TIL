package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SWEA_1953_탈주범검거 {

    static int T;

    static int n, m, r, c, l;

    static int[][] map;
    static boolean[][] visited;
    static Queue<int[]> queue;

    static int[] dr = {-1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};
    public static int[][] dir = {{0, 0, 0, 0}, {1, 1, 1, 1}, {1, 0, 1, 0}, {0, 1, 0, 1}, {1, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}, {1, 1, 0, 0}};
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

            result =0;
            for(int i = 0; i< n; i++){
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < m; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cnt = 0;
            queue.offer(new int[]{r, c});
            visited[r][c] = true;
            // bfs 수행
            while(!queue.isEmpty()){
                if(cnt == l) break;
                cnt++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] tmp = queue.poll();

                    int pr = tmp[0];
                    int pc = tmp[1];
                    result++;
                    nextPipe(pr, pc);
                }
                System.out.println(result);



            }
            for (int i = 0; i < n; i++) {
                System.out.println(Arrays.toString(visited[i]));
            }
            System.out.printf("#%d %d\n", t, result);
        }
    }

    private static void nextPipe(int pr, int pc) {
        List<int[]> tmp = new ArrayList<>();
        switch (map[pr][pc]){
            case 1:
                for (int i = 0; i < 4; i++) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!isCheck(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;

                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 2:
                dr2 = new int[]{1, -1};
                dc2 = new int[]{0, 0};
                for (int i = 0; i<2; i++) {
                    int nr = pr + dr2[i];
                    int nc = pc + dc2[i];
                    if(!isCheck(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 3:
                 dr2 = new int[]{0, 0};
                 dc2 = new int[]{-1, 1};
                for (int i = 0; i < 2; i++) {
                    int nr = pr + dr2[i];
                    int nc = pc + dc2[i];
                    if(!isCheck(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 4:
                dr2 = new int[]{-1, 0};
                dc2 = new int[]{0, 1};
                for (int i = 0; i < 2; i++) {
                    int nr = pr + dr2[i];
                    int nc = pc + dc2[i];
                    if(!isCheck(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 5:
                dr2 = new int[]{1, 0};
                dc2 = new int[]{0, 1};
                for (int i = 0; i < 2; i++) {
                    int nr = pr + dr2[i];
                    int nc = pc + dc2[i];
                    if(!isCheck(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 6:
                dr2 = new int[]{1, 0};
                dc2 = new int[]{0, -1};
                for (int i = 0; i < 2; i++) {
                    int nr = pr + dr2[i];
                    int nc = pc + dc2[i];
                    if(!isCheck(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
                break;
            case 7:
                dr2 = new int[]{-1, 0};
                dc2 = new int[]{0, -1};
                for (int i = 0; i < 2; i++) {
                    int nr = pr + dr2[i];
                    int nc = pc + dc2[i];
                    if(!isCheck(nr,nc) || visited[nr][nc] || map[nr][nc]==0) continue;
                    visited[nr][nc] = true;
                    queue.offer(new int[] {nr, nc});
                }
                break;
        }
    }

    private static boolean isCheck(int nr, int nc){
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
1
5 6 2 2 6
3 0 0 0 0 3
2 0 0 0 0 6
1 3 1 1 3 1
2 0 2 0 0 2
0 0 4 3 1 1
10 10 4 3 9
 */