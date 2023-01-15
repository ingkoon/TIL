package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_5653_줄기세포배양 {
    static int T;
    static int n, m, k;

    static Cell[][] map;
    static StringTokenizer st;

    static int SIZE = 20;
    static int MID = SIZE / 2;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            map = new Cell[SIZE][SIZE];

            for (int i = MID; i < MID + n; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = MID; j < MID + m; j++) {
                    int life = Integer.parseInt(st.nextToken());
                    if(life == 0) continue;
                    map[i][j] = new Cell(life, life, life);
                }
            }

            for (int i = 0; i < k; i++) {
                expansion();
            }

            for (Cell[] m : map) {
                System.out.println(Arrays.toString(m));
            }
            int result = 0;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if(map[i][j] == null) continue;
                    if(map[i][j].life > 0) result++;
                }
            }
            System.out.println(result);
        }
    }

    private static void expansion() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                //해당 위치가 초기화 된 위치인지 혹은 죽은 세포인지
                if(map[i][j] == null || map[i][j].life == 0) continue;

                // 잠들었다면
                if(map[i][j].wait > 0) {
                    map[i][j].wait --;
                    continue;
                }

                // 활동상태일 경우
                if(map[i][j].life > 0){
                    //사방으로 이동
                    for (int l = 0; l < 4; l++) {
                        int nr = i + dr[l];
                        int nc = j + dc[l];
                        // 다음 위치가 비어있을 경우
                        if(!isCheck(nr, nc))continue;
                        if(map[nr][nc] == null) {
                            // 초기화 수행
                            map[nr][nc] = new Cell(map[i][j].initSize, map[i][j].initSize, map[i][j].initSize);
                            continue;
                        } else {
                            // 갈수 없고, 이미 자는 시간이 줄거나 활동하고 있는 세포의 위치라면
                            if (!isActive(nr, nc)) continue;
                            // 방금 생성되었지만 생명이 더 작다면
                            if (isActive(nr, nc) && map[nr][nc].initSize > map[i][j].initSize) continue;
                            else if (isActive(nr, nc) && map[nr][nc].initSize < map[i][j].initSize) {
                                map[nr][nc] = new Cell(map[i][j].initSize, map[i][j].initSize, map[i][j].initSize);
                                continue;
                            }
//                            map[nr][nc] = new Cell(map[i][j].initSize, map[i][j].initSize, map[i][j].initSize);
                        }
                    }
                    map[i][j].life--;
                }

            }
        }
    }

    static class Cell{
        int initSize;
        int wait;
        int life;

        public Cell(int initSize, int wait, int life) {
            this.initSize = initSize;
            this.wait = wait;
            this.life = life;
        }

        @Override
        public String toString() {
            return   " " + initSize+"/" + life;
        }
    }

    //배열을 벗어나는지
    static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < SIZE && 0 <= nc && nc < SIZE;
    }

    // 해당 위치가 방금 초기화 된 위치인지
    static boolean isActive(int nr, int nc){
        return  map[nr][nc].initSize == map[nr][nc].life && map[nr][nc].initSize == map[nr][nc].wait ;
    }
}
