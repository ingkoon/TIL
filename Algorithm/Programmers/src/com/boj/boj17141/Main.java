package com.boj.boj17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 17141 연구소2
 */
public class Main {
    static int n, m;
    static int[][] board;
    static boolean[][] visited;
    static List<Virus> viruses;
    static boolean[] isVirus;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    static int answer = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];


        viruses = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int e = Integer.parseInt(st.nextToken());
                if(e == 2) viruses.add(new Virus(i, j, 0));
                board[i][j] = e;
            }
        }

        isVirus = new boolean[viruses.size()];

        selectVirus(0, 0);
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static void selectVirus(int cnt, int idx){
        if(cnt == m){
            cycleLab();
            return;
        }

        for(int i = idx; i < viruses.size(); i++){
            if(isVirus[i])
                continue;
            isVirus[i] = true;
            selectVirus(cnt+1, i+1);
            isVirus[i] = false;
        }
    }

    static void cycleLab(){
        visited = new boolean[n][n];
        Queue<Virus> queue = new LinkedList<>();

        for (int i = 0; i < viruses.size(); i++) {
            if(!isVirus[i]) continue;
            Virus v = viruses.get(i);
            visited[v.r][v.c] = true;
            queue.offer(v);
        }
        int result = 0;

        while (!queue.isEmpty()){
            Virus v = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nr = v.r + dr[i];
                int nc = v.c + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc] || board[nr][nc] == 1)
                    continue;
                visited[nr][nc] = true;
                result = Math.max(result, v.cnt+1);
                queue.offer(new Virus(nr, nc, v.cnt + 1));
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j] && board[i][j] != 1)
                    return;
            }
        }

        answer = Math.min(answer, result);
    }

    static boolean isCheck(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < n;
    }


    static class Virus{
        int r;
        int c;
        int cnt;

        public Virus(int r, int c, int cnt) {
            this.r = r;
            this.c = c;
            this.cnt = cnt;
        }
    }
}

