package com.level1;

import java.util.Stack;

public class Solution_크레인인형뽑기기계 {
    public static void main(String[] args) {
        int[][] board = new int[][] {{0,0,0,0,0},
                {0,0,1,0,3},
                {0,2,5,0,1},
                {4,2,4,4,2},
                {3, 5, 1, 3, 1}};

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        System.out.println(solution(board, moves));
    }
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int m : moves){
            for (int i = 0; i < board.length; i++) {
                if(board[i][m-1] == 0) continue;
                if(stack.isEmpty()) {
                    stack.push(board[i][m-1]);
                    board[i][m-1] = 0;
                }
                else if(stack.peek() == board[i][m-1]){
                    board[i][m-1] = 0;
                    stack.pop();
                    answer++;
                }
                else {
                    stack.push(board[i][m-1]);
                    board[i][m-1] = 0;
                }
                break;
            }
        }

        return answer * 2;
    }
}
