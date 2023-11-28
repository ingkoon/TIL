package com.boj.boj18405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, k;
    static int[][] board;
    static boolean[][] visited;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        board = new int[n][k];
        visited = new boolean[n][k];

        Queue<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                board[i][j] = tmp;

            }
        }

        for (int num = 1; num <= k; num++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == num)
                        queue.offer(new Node(i, j, num, 0));
                }
            }
        }

        int s, x, y;

        st = new StringTokenizer(bf.readLine());

        s = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        Node tmp = queue.peek();
        visited[tmp.r][tmp.c] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.time == s)
                break;
            for (int i = 0; i < 4; i++) {
                int nr = node.r + dr[i];
                int nc = node.c + dc[i];
                if(!isCheck(nr, nc) || board[nr][nc] != 0)
                    continue;
                board[nr][nc] = node.virus;
                queue.offer(new Node(nr, nc, node.virus, node.time+1));
            }
        }

        System.out.println(board[x-1][y-1]);
    }

    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < n && 0 <= nc && nc < n;
    }

    static class Node{
        int r;
        int c;
        int virus;
        int time;
        public Node(int r, int c, int virus, int time) {
            this.r = r;
            this.c = c;
            this.virus = virus;
            this.time = time;
        }
    }
}
