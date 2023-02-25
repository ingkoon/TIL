package com.boj.zum;

public class Solution3 {
    static int SIZE;

    public static void main(String[] args) {
        int[] histogram = {6, 5, 7, 3, 4, 2};
        int[] histogram2 = {2,2,2,3};
        System.out.println(solution(histogram2));
    }
    static int solution(int[] histogram) {
        int answer = -1;

        SIZE = histogram.length;

        int left = 0, right = SIZE-1;
        int leftMax = histogram[left];
        int rightMax = histogram[right];

        while(left < right){
            if(histogram[left] < histogram[right]){ // 좌측의 값이 더 작을 경우
                if(histogram[left] > leftMax) { // 다음 값이
                    leftMax = histogram[left];
                }
                answer = Math.max(answer, histogram[left] * (Math.abs(left - right)-1));
                ++left;
                continue;
            }

            if(histogram[right]  > rightMax ) {
                leftMax = histogram[left];
            }
            answer = Math.max(answer, histogram[right] * (Math.abs(left - right)-1));
            --right;
        }

        return answer;
    }
}
