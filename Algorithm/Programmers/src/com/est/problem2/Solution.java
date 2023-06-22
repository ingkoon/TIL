package com.est.problem2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] nums;

    public static void main(String[] args) {
        int[] input1 = {2, 1, 3, 1, 2, 1};
        System.out.println(Arrays.toString(solution(input1)));
    }
    static int[] solution(int[] queue) {

        nums = new int[4]; // 카운트를 하기 위함
        int[] answer = new int[3];
        Queue<Integer> numQueue = new LinkedList<>();

        for(int num : queue) { // queue에 값 삽입
            nums[num]++;
            numQueue.offer(num);
        }

        int[] tmp = isMin();
        int idx = tmp[0];
        int minVal = tmp[1];

        while(!isCheck()){
            int n = numQueue.poll();
            if( n == idx){ // 최솟값일 경우
                numQueue.offer(n);
            }
            nums[n] --; // 최솟값이 아닌값을 하나 차감시킨다.
            nums[idx] ++; // 최솟값을 하나 추가시킨다.
            numQueue.offer(idx); // queue에 최솟값을 하나 추가시킨다.
            answer[idx-1]++;
            idx = isMin()[0]; // 최솟값 갱신.
        }

        return answer;
    }
    static boolean isCheck(){
        int size = nums[1];
        for (int i = 2; i < 4; i++) {
            if(nums[i] != size)
                return false;
        }
        return true;
    }

    static int[] isMax(){ // 최댓값을 구하는 함수
        int idx = 1;
        int val = nums[1];
        for(int i = 2; i < 4; i ++){
            if(val < nums[i]){
                idx = i;
                val = nums[i];
            }
        }

        return new int[] {idx, val};
    }

    static int[] isMin(){ // 최댓값을 구하는 함수
        int idx = 1;
        int val = nums[1];
        for(int i = 2; i < 4; i ++){
            if(val > nums[i]){
                idx = i;
                val = nums[i];
            }
        }

        return new int[] {idx, val};
    }
}