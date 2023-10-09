package com.boj.boj6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
BOJ 6097 레이저 통신
 */
public class Main {
    static int w, h;
    static char[][] board;
    static boolean[][][] visited;
    static int SIZE = 10000;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        board = new char[h][w];
        visited = new boolean[4][h][w];

        int r = 0;
        int c = 0;


        for (int i = 0; i < h; i++) {
            char[] arr = bf.readLine().toCharArray();
            for (int j = 0; j < w; j++) {
                board[i][j] = arr[j];
                if(board[i][j] == 'C') {
                    r = i;
                    c = j;
                }
            }
        }

        board[r][c] = 'c';
        int result = bfs(r, c);
        System.out.println(result);
    }

    static int bfs(int r, int c){
        int result = Integer.MAX_VALUE;
        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.count - o2.count;
            }
        });
        queue.offer(new Node(r, c, 0, 0));
        visited[0][r][c] = true;
        boolean flag = false;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if(!isCheck(nr, nc) || visited[0][nr][nc] || board[nr][nc] == '*')
                continue;

            queue.offer(new Node(nr, nc, 0, i));
            visited[0][nr][nc] = true;
        }

        while (!queue.isEmpty()){
            Node node = queue.poll();
            if(board[node.r][node.c] == 'C'){
                if(flag){
                    result = Math.min(result, node.count);
                    break;
                }
                flag = true;
            }

            for (int i = 0; i < 4; i++) {

                int nr = node.r + dr[i];
                int nc = node.c + dc[i];

                if(!isCheck(nr, nc) || visited[node.dir][nr][nc] || board[nr][nc] == '*')
                    continue;

                if(node.dir != i){
                    queue.offer(new Node(nr, nc, node.count+1, i));
                }else{
                    queue.offer(new Node(nr, nc, node.count, i));
                }
            }
        }

        return result;
    }
    static boolean isCheck(int r, int c){
        return 0 <= r && r < h && 0 <= c && c < w;
    }

    static class Node{
        int r;
        int c;

        int count;
        int dir;

        public Node(int r, int c, int count, int dir) {
            this.r = r;
            this.c = c;
            this.count = count;
            this.dir = dir;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "r=" + r +
                    ", c=" + c +
                    ", count=" + count +
                    ", dir=" + dir +
                    '}';
        }
    }
}

