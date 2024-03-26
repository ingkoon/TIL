package com.boj5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int w, h;
    static char[][] board;
    static boolean[][] visited;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            board = new char[h][w];
            visited = new boolean[h][w];

            int r = 0;
            int c = 0;

            Queue<Loc> queue = new LinkedList<>();

            for (int i = 0; i < h; i++) {
                char[] tmp= bf.readLine().toCharArray();
                for (int j = 0; j < w; j++) {
                    char e = tmp[j];
                    board[i][j] = e;
                    if(e == '@'){
                        r = i;
                        c = j;
                    }
                    else if (e == '#' || e == '*'){
                        visited[i][j] = true;
                        if(e == '*')
                            queue.offer(new Loc(i, j, 0));
                    }
                }
            }
            Runner runner = new Runner(r, c, 0);
            bfs(runner, queue);
        }
    }

    static void bfs(Runner runner, Queue<Loc> queue){
        Queue<Runner> runnerQueue = new LinkedList<>();
        runnerQueue.offer(runner);
        visited[runner.r][runner.c] = true;
        int turn = 0;
        while (!runnerQueue.isEmpty()){
            expandedFire(turn, queue);
            while (!runnerQueue.isEmpty() && runnerQueue.peek().turn == turn){
                Runner cur = runnerQueue.poll();
                int pr = cur.r;
                int pc = cur.c;
                for (int i = 0; i < 4; i++) {
                    int nr = pr + dr[i];
                    int nc = pc + dc[i];
                    if(!isCheck(nr, nc)){
                        System.out.println(cur.turn+1);
                        return;
                    }
                    if(visited[nr][nc])
                        continue;
                    visited[nr][nc] = true;
                    runnerQueue.offer(new Runner(nr, nc, turn+1));
                }
            }
            turn++;
        }
        System.out.println("IMPOSSIBLE");
    }

    static void expandedFire(int turn, Queue<Loc> queue){
        while(!queue.isEmpty() && queue.peek().turn == turn){
            Loc loc = queue.poll();
            int pr = loc.r;
            int pc = loc.c;
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(!isCheck(nr,nc) || visited[nr][nc])
                    continue;
                visited[nr][nc] = true;
                queue.offer(new Loc(nr, nc, loc.turn+1));
            }
        }
    }

    static boolean isCheck(int pr, int pc){
        return 0 <= pr && pr < h && 0 <= pc && pc < w;
    }

    static class Runner {
        int r, c, turn;
        public Runner(int r, int c, int turn) {
            this.r = r;
            this.c = c;
            this.turn = turn;
        }
    }

    static class Loc{
        int r, c, turn;
        public Loc(int r, int c, int turn) {
            this.r = r;
            this.c = c;
            this.turn = turn;
        }
    }
}
