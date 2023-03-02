package com.level1;

import java.util.Arrays;

public class Solution_소수만들기 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(solution(nums));
    }

    static int size;
    static boolean[] visited;
    static int[] staticNum;
    static int answer;

    public static int solution(int[] nums) {
        size = nums.length;
        staticNum = nums.clone();
        visited = new boolean[size];

        nPr(0, 0);

        return answer;
    }
    public static void nPr(int cnt, int start){
        if(cnt == 3){
            int tmp = 0;
            for(int i = 0; i < size; i++){
                if(visited[i]) tmp += staticNum[i];
            }

            answer += isPrime(tmp) ? 0 : 1;
            return;
        }

        for (int i = start; i < size; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            nPr(cnt+1, i);
            visited[i]= false;
        }
    }

    public static boolean isPrime(int num){
        for (int i = 2; i < (int)num/2; i++) {
            if(num % i == 0) return true;
        }
        return false;
    }
}
