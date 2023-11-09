package com.boj.boj14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine(), " ");
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = getResult();

        System.out.println(result);
    }

    static int getResult(){
        int result =  0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result = Math.max(result, getTetro1(i,j));
                result = Math.max(result, getTetro2(i,j));
                result = Math.max(result, getTetro2V1(i,j));
                result = Math.max(result, getTetro3(i,j));
                result = Math.max(result, getTetro3V1(i,j));
                result = Math.max(result, getTetro3V2(i,j));
                result = Math.max(result, getTetro3V3(i,j));
                result = Math.max(result, getTetro3V4(i,j));
                result = Math.max(result, getTetro3V5(i,j));
                result = Math.max(result, getTetro3V6(i,j));
                result = Math.max(result, getTetro3V7(i,j));
                result = Math.max(result, getTetro4(i,j));
                result = Math.max(result, getTetro4V1(i,j));
                result = Math.max(result, getTetro4V2(i,j));
                result = Math.max(result, getTetro4V3(i,j));
                result = Math.max(result, getTetro5(i,j));
                result = Math.max(result, getTetro5V1(i,j));
                result = Math.max(result, getTetro5V2(i,j));
                result = Math.max(result, getTetro5V3(i,j));
            }
        }
        return result;
    }

    static int getTetro1(int r, int c){ // 사각형 모양의 테크로미노
        int result = 0;
        for(int i = r; i <= r + 1; i++){
            for (int j = c; j <= c + 1; j++) {
                if(!isCheck(i, j))
                    return -1;
                result += board[i][j];
            }
        }
        return result;
    }

    static int getTetro2(int r, int c){ //세로 형태의 테크로미노
        int result = 0;
        for (int i = r; i <= r + 3; i++) {
            if(!isCheck(i, c))
                return -1;
            result += board[i][c];
        }
        return result;
    }

    static int getTetro2V1(int r, int c){ // 가로 형태의 테크로미노
        int result = 0;
        for (int i = c; i <= c + 3; i++) {
            if(!isCheck(r, i))
                return -1;
            result += board[r][i];
        }
        return result;
    }

    static int getTetro3(int r, int c){ // L형태의 테크로미노 값 구현
        int result = 0;
        for (int i = r; i <= r + 2; i++) {
            if(!isCheck(i, c))
                return -1;
            result += board[i][c];
        }
        if(!isCheck(r + 2, c + 1))
            return -1;
        result += board[r+2][c + 1];
        return result;
    }

    static int getTetro3V1(int r, int c){ // L이 왼쪽으로 뒤집힌 형태의 값을 구한다.
        int result = 0;
        for (int i = r; i <= r + 2; i++) {
            if(!isCheck(i, c))
                return -1;
            result += board[i][c];
        }
        if(!isCheck(r + 2, c - 1))
            return -1;
        result += board[r+2][c - 1];
        return result;
    }
    static int getTetro3V2(int r, int c){ // L이 아래로으로 뒤집힌 형태의 값을 구한다.
        int result = 0;
        if(!isCheck(r, c + 1))
            return -1;
        result += board[r][c + 1];
        for (int i = r; i <= r + 2; i++) {
            if(!isCheck(i, c))
                return -1;
            result += board[i][c];
        }

        return result;
    }

    static int getTetro3V3(int r, int c){ // L이 아래로으로 뒤집힌 형태의 값을 구한다.
        int result = 0;
        if(!isCheck(r, c - 1))
            return -1;
        result += board[r][c - 1];
        for (int i = r; i <= r + 2; i++) {
            if(!isCheck(i, c))
                return -1;
            result += board[i][c];
        }

        return result;
    }

    static int getTetro3V4(int r, int c){ // L이 아래로으로 뒤집힌 형태의 값을 구한다.
        int result = 0;
        if(!isCheck(r+1, c))
            return -1;
        result += board[r+1][c];
        for (int i = c; i <= c + 2; i++) {
            if(!isCheck(r,i))
                return -1;
            result += board[r][i];
        }

        return result;
    }

    static int getTetro3V5(int r, int c){ // L이 아래로으로 뒤집힌 형태의 값을 구한다.
        int result = 0;
        if(!isCheck(r-1, c))
            return -1;
        result += board[r-1][c];
        for (int i = c; i <= c + 2; i++) {
            if(!isCheck(r,i))
                return -1;
            result += board[r][i];
        }

        return result;
    }

    static int getTetro3V6(int r, int c){ // L이 아래로으로 뒤집힌 형태의 값을 구한다.
        int result = 0;
        if(!isCheck(r+1, c+2))
            return -1;
        result += board[r+1][c+2];
        for (int i = c; i <= c + 2; i++) {
            if(!isCheck(r,i))
                return -1;
            result += board[r][i];
        }

        return result;
    }

    static int getTetro3V7(int r, int c){ // L이 아래로으로 뒤집힌 형태의 값을 구한다.
        int result = 0;
        if(!isCheck(r-1, c+2))
            return -1;
        result += board[r-1][c+2];
        for (int i = c; i <= c + 2; i++) {
            if(!isCheck(r,i))
                return -1;
            result += board[r][i];
        }

        return result;
    }

    static int getTetro4(int r, int c){
        int result = 0;
        if(!isCheck(r, c)
                || !isCheck(r + 1, c)
                || !isCheck(r + 1, c + 1)
                || !isCheck(r + 2, c + 1)){
            return -1;
        }
        result += board[r][c] + board[r+1][c] + board[r+1][c+1] + board[r+2][c+1];
        return result;
    }

    static int getTetro4V1(int r, int c){// 번개보양 테트로미노를 왼쪽으로
        int result = 0;
        if(!isCheck(r, c)
                || !isCheck(r + 1, c)
                || !isCheck(r + 1, c - 1)
                || !isCheck(r +  2, c - 1)){
            return -1;
        }
        result += board[r][c] + board[r+1][c] + board[r+1][c-1] + board[r+2][c-1];
        return result;
    }

    static int getTetro4V2(int r, int c){// 번개보양 테트로미노를 가로로
        int result = 0;
        if(!isCheck(r, c)
                || !isCheck(r, c+1)
                || !isCheck(r - 1, c + 1)
                || !isCheck(r - 1, c + 2)){
            return -1;
        }
        result += board[r][c] + board[r][c+1] + board[r-1][c+1] + board[r-1][c+2];
        return result;
    }

    static int getTetro4V3(int r, int c){// 번개보양 테트로미노를 가로로
        int result = 0;
        if(!isCheck(r, c)
                || !isCheck(r, c + 1)
                || !isCheck(r + 1, c + 1)
                || !isCheck(r + 1, c + 2)){
            return -1;
        }
        result += board[r][c] + board[r][c+1] + board[r+1][c+1] + board[r+1][c+2];
        return result;
    }

    static int getTetro5(int r, int c){
        int result = 0;
        for (int i = r; i <= r+2; i++) {
            if(!isCheck(i, c))
                return  -1;
            result += board[i][c];
        }
        if(!isCheck(r + 1, c + 1))
            return -1;
        result += board[r+1][c+1];
        return result;
    }

    static int getTetro5V1(int r, int c){
        int result = 0;
        for (int i = r; i <= r+2; i++) {
            if(!isCheck(i, c))
                return  -1;
            result += board[i][c];
        }
        if(!isCheck(r + 1, c - 1))
            return -1;
        result += board[r+1][c-1];
        return result;
    }

    static int getTetro5V2(int r, int c){
        int result = 0;
        for (int i = c; i <= c+2; i++) {
            if(!isCheck(r, i))
                return  -1;
            result += board[r][i];
        }
        if(!isCheck(r + 1, c + 1))
            return -1;
        result += board[r+1][c+1];
        return result;
    }

    static int getTetro5V3(int r, int c){
        int result = 0;
        for (int i = c; i <= c+2; i++) {
            if(!isCheck(r, i))
                return  -1;
            result += board[r][i];
        }
        if(!isCheck(r - 1, c + 1))
            return -1;
        result += board[r-1][c+1];
        return result;
    }

    static boolean isCheck(int r, int c){ // 테크로미노의 범위가 board를 벗어나는지 판별하는 함수
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}
