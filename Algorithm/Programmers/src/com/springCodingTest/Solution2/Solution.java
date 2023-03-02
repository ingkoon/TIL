package com.springCodingTest.Solution2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    static char[][] board;
    static boolean[][] visited;
    static int SIZE;
    static Queue<Node> queue;

    public static void main(String[] args) {
        String[] input1 = {
                ".....####",
                "..#...###",
                ".#.##..##",
                "..#..#...",
                "..#...#..",
                "...###..."};
        System.out.println(solution(input1));
    }
    static int solution(String[] grid) {
        int answer = 0;
        SIZE = grid.length;
        board = new char[SIZE][SIZE];
        visited = new boolean[SIZE][SIZE];

        for (int i = 0; i < SIZE; i++) { // 배열 초기화
            board[i] = grid[i].toCharArray();
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if(visited[i][j] || board[i][j] == '.') continue;
                visited[i][j] = true;
                bfs(i, j);
            }
        }

        for (boolean[] booleans : visited) {
            System.out.println(Arrays.toString(booleans));
        }
        return answer;
    }

    static void bfs(int r, int c){
        queue = new LinkedList<>();
        queue.offer(new Node(r, c));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int pr = node.r;
            int pc = node.c;
            for (int i = 0; i < 8; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(!isCheck(nr, nc) || board[nr][nc]=='.' || visited[nr][nc]) continue;
                visited[nr][nc] = true;
                queue.offer(new Node(nr, nc));
            }
        }
    }

    static boolean isCheck(int nr, int nc){
        return 0<=nr&&nr<SIZE&&0<=nc&&nc<SIZE;
    }

    static class Node{
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
