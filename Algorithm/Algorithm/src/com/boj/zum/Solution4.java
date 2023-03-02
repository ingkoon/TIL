package com.boj.zum;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {
    public static void main(String[] args) {
        int[][] grid = {{2, 1, 1, 3, 5, 1}, {1, 1, 3, 3, 5, 5}, {8, 3, 3, 3, 1, 5}, {3, 3, 3, 4, 4, 4}, {3, 3, 4, 4, 4, 4}, {1, 4, 4, 4, 4, 4}};
        int[][] grid2 = {{10, 20, 30}, {40, 50, 60}, {70, 80, 90}};
        int[][] grid3 = {{1, 1, 1, 1}, {1, 1, 1, 1}};
        System.out.println(Arrays.toString(solution(grid3)));
    }

    static int[] dr = {0 ,1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    static int[] arr;
    static int r, c;
    static int[] solution(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        int[] answer = {};

        int size = 701;
        visited = new boolean[r][c];
        arr = new int[size];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(visited[i][j]) continue;
                int[] result = bfs(i, j, grid);
                arr[result[0]] += result[1];
            }
        }

        for(int i = size-1; i >= 0; i--){
            if(arr[i]!=0) {
                answer = new int[]{i, arr[i]};
                break;
            }
        }
        return answer;
    }
    static int[] bfs(int tmpR, int tmpC, int[][] grid){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(grid[tmpR][tmpC], tmpR, tmpC));
        visited[tmpR][tmpC] = true;

        int cnt = 1;

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int pr = node.r;
            int pc = node.c;
            int val = node.val;
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc] || grid[nr][nc] != val) continue;
                queue.offer(new Node(val, nr, nc));
                visited[nr][nc] = true;
                cnt++;
            }
        }
        System.out.println(cnt);
        if(cnt == r * c) return new int[]{(int) Math.sqrt(cnt), 1};
        return new int[]{(int) Math.sqrt(cnt), 1};
    }

    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < r && 0 <= nc && nc < c;
    }
    static class Node{
        int val;
        int r;
        int c;

        public Node(int val, int r, int c) {
            this.val = val;
            this.r = r;
            this.c = c;
        }
    }
}
