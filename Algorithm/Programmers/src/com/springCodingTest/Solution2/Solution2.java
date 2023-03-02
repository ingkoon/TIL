package com.springCodingTest.Solution2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {

    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    static char[][] board;
    static boolean[][] visited;
    static int SIZE;


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
            }
        }

        for (boolean[] booleans : visited) {
            System.out.println(Arrays.toString(booleans));
        }
        return answer;
    }

}
