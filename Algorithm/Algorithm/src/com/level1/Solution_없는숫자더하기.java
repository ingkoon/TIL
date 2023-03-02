package com.level1;

import java.util.Arrays;

public class Solution_없는숫자더하기 {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,6,7,8,0};
        System.out.println(solution(numbers));
    }

    private static int solution(int[] numbers){
        int answer = 0;

        for (int i = 0; i < 10; i++) {
            int tmp = i;
            if(Arrays.stream(numbers).anyMatch(x -> x == tmp)) continue;
            answer+=i;
        }
        return answer;
    }
}
