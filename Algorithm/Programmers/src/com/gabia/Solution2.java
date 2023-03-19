package com.gabia;

public class Solution2 {
    public static void main(String[] args) {
        int[] dots ={1, 5, 8};
        int[] lines = {1, 3, 4, 6};
        System.out.println(solution(dots, lines));
    }
    static int solution(int[] dots, int[] lines){
        int answer = 0;
        int i = 0;
        while(i < dots.length){
            int end = -1;
            for (int line : lines) {
                int tmp = coverIdx(dots, i, line);
                if (tmp != -1 && tmp > end) {
                    end = tmp;
                }
            }
            if (end == -1)
                return -1;
            answer++;
            i = end + 1;
        }
        return answer;
    }
    static int coverIdx(int[] dots, int start, int line) {
        int end = -1;
        for (int i = start; i < dots.length; i++) {
            if (dots[i] - dots[start] <= line) {
                end = i;
                continue;
            }
            break;
        }
        return end;
    }
}
