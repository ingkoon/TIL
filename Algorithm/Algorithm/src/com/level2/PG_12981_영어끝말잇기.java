package com.level2;

import java.util.Arrays;
import java.util.Stack;

public class PG_12981_영어끝말잇기 {
    public static void main(String[] args) {
        String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int SIZE = 3;
        int[] result = solution(SIZE, words);
        System.out.println(Arrays.toString(result));

    }
    static Stack<String> stack;
    static int[] solution(int n, String[] words) {
        int[] answer = {0, 0};

        int cnt = 1;
        int size = words.length;

        stack = new Stack<>();
        stack.push(words[0]); // 끝말잇기의 시작값 추가
        for (int i = 1; i <size; i++) {
            if(i % n == 0) cnt++; // 한번 순회할때마다 자신의 차례 증가
            String prev = stack.peek();
            String next = words[i];
            if(!isContinue(prev, next) || isCheck(next)) {
                answer[0] = i%n+1;
                answer[1] = cnt;
                break;
            }
            stack.push(next);
        }

        return answer;
    }
    static boolean isContinue(String prev, String next){
        return prev.charAt(prev.length() -1) == next.charAt(0);
    }
    static boolean isCheck(String word){
        return stack.contains(word);
    }
}
