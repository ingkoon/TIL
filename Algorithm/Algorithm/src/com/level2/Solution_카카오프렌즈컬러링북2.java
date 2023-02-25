package com.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_카카오프렌즈컬러링북2 {
    public static void main(String[] args) {
        int m = 6;
        int n =4 ;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};

        Solution_카카오프렌즈컬러링북2 s = new Solution_카카오프렌즈컬러링북2();
        int[] answer = s.solution(m,n,picture);
        System.out.println(Arrays.toString(answer));
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int count = 0;
    static int size = Integer.MIN_VALUE;

    static int w;
    static int h;

    static boolean[][] visited;
    public int[] solution(int m, int n, int[][] picture) {
        int[] answer = new int[2];
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j, picture);
            }
        }
        w = n;
        h = m;
        answer[0] = count;
        answer[1] = size;

        return answer;
    }

    public void bfs(int y, int x, int[][] picture){
        if(picture[y][x] == 0 || visited[y][x]) return;

        count++;
        
        int tmpSize= 0;
        Queue<Color> queue = new LinkedList<>();
        queue.offer(new Color(x,y));

        while(!queue.isEmpty()){
            Color c = queue.poll();
            int px = c.x;
            int py = c.y;
            for (int i = 0; i < 4; i++) {
                int nx = px + dx[i];
                int ny = py + dy[i];

                if(isCheck(nx, ny)&& picture[ny][nx] != 0 && !visited[ny][nx]){
                    tmpSize +=0;
                    visited[ny][nx] = true;
                    queue.offer(new Color(nx, ny));
                }
            }
        }
        size = Math.max(size, tmpSize);
    }

    private boolean isCheck(int nx, int ny) {
        return (nx >=0 && nx < w && ny >= 0 && ny < h);
    }

    static class Color {
        int x;
        int y;
        public Color(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
