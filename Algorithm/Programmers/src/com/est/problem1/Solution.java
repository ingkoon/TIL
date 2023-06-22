package com.est.problem1;

import java.util.*;
public class Solution {
    public static void main(String[] args) {
        int[][] input = {{0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 1, 0, 0, 1}, {0, 1, 0, 1, 0, 0, 1}, {1, 1, 2, 2, 1, 0, 1}, {2, 2, 2, 2, 1, 2, 2}, {2, 2, 1, 1, 1, 2, 2}, {2, 2, 1, 1, 1, 2, 2}};
        System.out.println(solution(input));
    }

    static int[] result;

    static int solution(int[][] histogram) {
        int c = histogram[0].length;
        int r = histogram.length;
        result = new int[c];
        for(int i = 0;  i < c; i++){
            boolean flag = false;
            int cnt = 1;
            for(int j = 0; j < r; j++){
                if(histogram[j][i] == 2 && !flag){
                    cnt++;
                    flag = true;
                    continue;
                }
                if(flag && histogram[j][i] == 0){
                    cnt = 1;
                    flag = false;
                    continue;
                }
                if(!flag && (histogram[j][i] == 0))
                    continue;
                if(flag && histogram[j][i] == 2 ){
                    cnt++;
                    continue;
                }
                if(histogram[j][i] == 1)
                    break;
            }
            result[i] = cnt;
        }
        System.out.println(Arrays.toString(result));
        int answer = 0;
        return answer;
    }
}
/*
가장 위에서부터 내려오면서 탐색 진행
2일 경우에만 탐색을 이어서 진행한다.
다음 부분이 0일 경우 해당 예측 부분은 무효
1일 경우에는 해당 위치에서 +1 한 값을 가져다 사용한다.
모든 막대를 순회 후 각각의 
*/