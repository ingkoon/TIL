package com.level2;

import java.util.Arrays;

public class PG_42747_Hindex {
    public static void main(String[] args) {
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(solution(citations));
    }

    static int solution(int[] citations){
        int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            int tmp = citations.length - i;
            if(citations[i] >= tmp){
                answer = tmp;
                break;
            }
        }
        return answer;
    }
}
/*
0, 1, 3, 5, 6
1 = 0
2 = 1
3 = 3
4 = 5
5 = 6
 */