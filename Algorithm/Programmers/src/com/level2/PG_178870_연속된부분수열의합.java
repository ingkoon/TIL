package com.level2;

import java.util.Arrays;

public class PG_178870_연속된부분수열의합 {
    static int start, end;

    public static void main(String[] args) {
        int[] input1 = {1, 2, 3, 4, 5};
        int input1K = 7;
        System.out.println(Arrays.toString(solution(input1, input1K)));
    }
    static int[] solution(int[] sequence, int k) {
        int SIZE = sequence.length;
        end = SIZE;
        int sum = 0;

        for(int left = 0, right = 0; left < SIZE; left++){
            while(right < SIZE && sum < k)
                sum += sequence[right++];
            if(sum == k){
                checkValue(left, right, k);
            }
            sum -= sequence[left];
        }

        int[] answer = {start, end - 1};
        return answer;
    }

    static void checkValue(int left, int right, int k){
        if(end - start > right - left){
            end = right;
            start = left;
        }
    }
}
