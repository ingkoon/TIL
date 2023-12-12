package com.boj.boj10703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int r, s;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        board = new char[r][s];

        for (int i = 0; i < r; i++) {
            char[] tmp = bf.readLine().toCharArray();
            board[i] = tmp.clone();
        }

        int distance = getDistance();

        for (int i = r-1; i >= 0; i--) {
            for (int j = 0; j < s; j++) {
                if(board[i][j] == 'X' && board[i+distance][j] == '.'){
                    char tmp = board[i][j];
                    board[i][j] = board[i+distance][j];
                    board[i+distance][j]= tmp;

                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    // 지면과 가장 가까운 유성의 거리를 탐색하는 함수
    static int getDistance() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < s; i++) {
            int top = -1;
            int bottom = r;

            for (int j = 0; j < r; j++) {
                if (board[j][i] == 'X' && board[j + 1][i] == '.') {
                    top = j;
                }
            }

            if(top == -1)
                continue;

            for (int j = top; j < r; j++) {
                if(board[j][i] == '#') {
                    bottom = j;
                    break;
                }
            }

            int tmp = bottom - top;
            min = Math.min(min, tmp);
        }

        return min - 1;
    }
}
/**
 * 완탐을 사용하기엔 3000 * 3000 * 3000이라서 조금 아쉽다.
 */
