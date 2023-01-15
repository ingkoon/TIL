package com.level2;

import java.util.*;

public class Solution_카카오프렌즈컬러링북 {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {
                {1, 1, 1, 0},
                {1, 2, 2, 0},
                {1, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 3},
                {0, 0, 0, 3}};

        Solution_카카오프렌즈컬러링북 s = new Solution_카카오프렌즈컬러링북();
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
        w = n;
        h = m;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                bfs(i, j, picture);
            }
        }

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
            for (int d = 0; d < 4; d++) {
                int nx = px + dx[d];
                int ny = py + dy[d];

                if(isCheck(nx, ny) && picture[ny][nx] > 0 && picture[y][x] == picture[ny][nx]   && !visited[ny][nx]){

                    tmpSize += 1;
                    visited[ny][nx] = true;
                    queue.offer(new Color(nx, ny));
                }
            }
        }

        System.out.println(tmpSize + " " +  count);
        size = Math.max(size, tmpSize);
    }

    private boolean isCheck(int nx, int ny) {
        return (nx >= 0 && nx < w && ny >= 0 && ny < h);
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
