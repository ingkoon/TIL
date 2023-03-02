package com.springCodingTest.Solution3;

import java.util.Arrays;

public class Solution3 {
    public static void main(String[] args) {

        int[][] input1 = {{1, 4, 3}, {1, 2, 2}};
        System.out.println(Arrays.toString(solution(input1)));
    }

    static int[] solution(int[][] queries){
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int size = queries[i].length;
            int left = 0;
            int right = size-1;

            boolean turn = true; // true일 경우 1번 사용자 턴, false일 경우 2번 사용자 턴
            while (!isSuccess(queries[i])){
                if(queries[i][left] == queries[i][right]) {
                    left++;
                    right--;
                    continue;
                }
                if(queries[i][left] > queries[i][right]){
                    queries[i][left]--;
                    turn = !turn;
                    continue;
                }
                queries[i][right]--;
                turn = !turn;
            }

            if(!turn) {
                answer[i] = 1;
            }
        }
        return answer;
    }

    static boolean isSuccess(int[] query){
        int size = query.length-1;
        for (int i = 0; i < query.length; i++) {
            if(query[i] != query[size-i]) return false;
        }
        return true;
    }
}
