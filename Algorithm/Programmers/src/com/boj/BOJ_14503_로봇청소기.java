package com.boj;

import java.util.Scanner;

public class BOJ_14503_로봇청소기 {
    static int n, m;
    static int r, c, d;

    static int[][] board;
    static int result;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        r = sc.nextInt();
        c = sc.nextInt();
        d = sc.nextInt();

        board = new int[n][m];

        while(check(r, c)){
            int nd = d == 0 ? 3 : d-1;
            int lr = r + dr[nd];
            int lc = r + dc[nd];
            if(checkV2(lr, lc)) {
                board[lr][lc] = 1;
                result ++;
                d = nd;
                r = lr;
                c = lc;
                System.out.println(r + " " + c);
                continue;
            };

            d = nd;

        }
        System.out.println(result);
    }

    // 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우
    private static boolean check(int pr, int pc) {
        boolean flag = false;
        // 반대쪽을 확인하기 위한 변수 br, bc
        int br = pr + dr[d == 1 ? 3 : Math.abs(d - 2)];
        int bc = pc + dc[d == 1 ? 3 : Math.abs(d - 2)];

        //현재 위치에서 4방향으로 갈 수 있는지 확인
        for (int i = 0; i < 4; i++) {
            int nr = pr + dr[i];
            int nc = pc + dc[i];
            if ((0 <= pr && pr < n && 0 <= pc && pc < m) && (board[nr][nc] != 1)) {
                return true;
            }
        }

        if(0>br&& br >= n && 0 > bc && bc >= m) return false;
        return flag;
    }

    private static boolean checkV2(int pr, int pc){
        return 0 <= pr && pr <n && 0<= pc && pc < m && board[pr][pc] != 1;
    }


}

/**
 * 0, 1, 2, 3
로봇 청소기가 주어졌을 때, 청소하는 영역의 개수를 구하는 프로그램을 작성하시오.

로봇 청소기가 있는 장소는 N×M 크기의 직사각형으로 나타낼 수 있으며, 1×1크기의 정사각형 칸으로 나누어져 있다. 각각의 칸은 벽 또는 빈 칸이다. 청소기는 바라보는 방향이 있으며, 이 방향은 동, 서, 남, 북중 하나이다. 지도의 각 칸은 (r, c)로 나타낼 수 있고, r은 북쪽으로부터 떨어진 칸의 개수, c는 서쪽으로 부터 떨어진 칸의 개수이다.

로봇 청소기는 다음과 같이 작동한다.

1현재 위치를 청소한다.
2.현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
1.왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
2.왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
3.네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
4.네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.

입력
첫째 줄에 세로 크기 N과 가로 크기 M이 주어진다. (3 ≤ N, M ≤ 50)

둘째 줄에 로봇 청소기가 있는 칸의 좌표 (r, c)와 바라보는 방향 d가 주어진다. d가 0인 경우에는 북쪽을, 1인 경우에는 동쪽을, 2인 경우에는 남쪽을, 3인 경우에는 서쪽을 바라보고 있는 것이다.

셋째 줄부터 N개의 줄에 장소의 상태가 북쪽부터 남쪽 순서대로, 각 줄은 서쪽부터 동쪽 순서대로 주어진다. 빈 칸은 0, 벽은 1로 주어진다. 지도의 첫 행, 마지막 행, 첫 열, 마지막 열에 있는 모든 칸은 벽이다.

로봇 청소기가 있는 칸의 상태는 항상 빈 칸이다.

출력
로봇 청소기가 청소하는 칸의 개수를 출력한다.
 */
