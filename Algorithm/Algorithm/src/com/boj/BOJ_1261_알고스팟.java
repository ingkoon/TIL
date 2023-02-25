package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1261_알고스팟 {
    static int r, c;

    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1 ,0};
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        maze = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; i++) {
            String s = bf.readLine();
            for (int j = 0; j < c; j++) {
                maze[i][j] = Integer.parseInt(s.charAt(j)+"");
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.val - o2.val;
            }
        });
        queue.offer(new Node(0, 0, 0));

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int pr = node.pr;
            int pc = node.pc;
            int pVal = node.val;

            if(pr == r-1 && pc == c-1){
                System.out.println(pVal);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(nr == 0 && nc == 0) continue;
                if(!isCheck(nr, nc) || visited[nr][nc]) continue;
                if(maze[nr][nc] == 1) {
                    queue.offer(new Node(nr, nc, pVal+1));
                    visited[nr][nc] = true;
                    continue;
                }
                visited[nr][nc] = true;
                queue.offer(new Node(nr, nc, pVal));
            }
        }
    }

    static class Node{
        int pr;
        int pc;

        int val;

        public Node(int pr, int pc, int val) {
            this.pr = pr;
            this.pc = pc;
            this.val = val;
        }
    }

    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr <r && 0<= nc && nc < c;
    }
}
