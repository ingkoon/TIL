package com.boj.boj2239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int SIZE = 9;
    static int LIST_SIZE;
    static int[][] board = new int[SIZE][SIZE];
    static List<Node> blankList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        blankList = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            String[] arr = bf.readLine().split("");
            for (int j = 0; j < SIZE; j++) {
                int tmp = Integer.parseInt(arr[j]);
                board[i][j] = tmp;
                if(tmp == 0)
                    blankList.add(new Node(i, j));
            }
        }
        LIST_SIZE = blankList.size();

        backTracking(0);
    }

    static void backTracking(int idx){
        if(idx == LIST_SIZE){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < SIZE-1; i++) {
                for (int j = 0; j < SIZE; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }

            for (int i = 0; i < SIZE; i++) {
                sb.append(board[SIZE-1][i]);
            }
            System.out.println(sb);
            System.exit(0);
        }

        Node node = blankList.get(idx);

        int r = node.r;
        int c = node.c;

        for (int i = 1; i <= SIZE ; i++) {
            if(!isSquare(r, c, i) || !isCross(r, c, i))
                continue;
            board[r][c] = i;
            backTracking(idx+1);
            board[r][c] = 0;
        }
    }

    static boolean isSquare(int r, int c, int num){ // 정사각형 범위 내 같은 수 존재하는지 확인
        int sr = (r / 3) * 3;
        int sc = (c / 3) * 3;

        for (int i = sr; i < sr + 3; i++) {
            for (int j = sc; j < sc + 3; j++) {
                if(board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    static boolean isCross(int r, int c, int num){ // 가로에 일치하는 수가 존재하는지 확인
        for (int i = 0; i < SIZE; i++) {
            if(board[r][i] == num || board[i][c] == num)
                return false;
        }
        return true;
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
