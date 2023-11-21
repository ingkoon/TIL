package com.boj.boj2638;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m, result;
    static int[][] board;
    static boolean[][] visited;

    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(!isMelted()){
            result++;
            setAir(); // 초기 공기 위치들에 대해 visited = true 설정

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(isMeltCheese(i, j)){
                        board[i][j] = 0;
                    }
                }
            }
            visited = new boolean[n][m];
        }

        System.out.println(result);
    }
    static boolean isMelted(){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j] == 1)
                    return false;
            }
        }
        return true;
    }


    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < n && 0 <= nc && nc < m;
    }

    static boolean isMeltCheese(int r, int c) { // 현재 위치의 치즈가 녹아 없어질 치즈인지에 대한 확인
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (!isCheck(nr, nc)) // 모눈종이 크기를 벗어나는지 확인
                continue;
            if (board[nr][nc] == 0 && visited[nr][nc]) { // 공기이면서 외부 공기일 경우
                cnt++;
            }
        }
        return cnt >= 2; // cnt가 2보다 클 경우 해당 치즈는 녹는 치즈이다.
    }


    static void setAir(){ //초기 공기 위치를 찾아 visited = true로 바꾸는 함수
        Queue<Place> isAir = new LinkedList<>();
        isAir.offer(new Place(0, 0));

        while(!isAir.isEmpty()){
            Place place = isAir.poll();
            for (int i = 0; i < 4; i++) {
                int nr = place.r + dr[i];
                int nc = place.c + dc[i];
                if(!isCheck(nr, nc) || visited[nr][nc] || board[nr][nc] == 1)
                    continue;
                visited[nr][nc] = true;
                isAir.offer(new Place(nr, nc));
            }
        }
    }

    static class Place{
        int r;
        int c;

        public Place(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
