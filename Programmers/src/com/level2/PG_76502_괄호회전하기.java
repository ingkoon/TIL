package com.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PG_76502_괄호회전하기 {
    public static void main(String[] args) {
        String input = "[](){}";
        System.out.println(solution(input));
    }

    static int solution(String s) {
        int result = 0;
        Queue<Character> queue;
        char[] arr = s.toCharArray();
        queue = new LinkedList<>();
        for (char c : arr) queue.offer(c); // 스택 초기화

        if(isCheck(queue)) result++;

        for(int i=0; i< arr.length-1; i++){
            char tmp = queue.poll();
            System.out.println(Arrays.toString(queue.toArray()));
            queue.offer(tmp);
            System.out.println(Arrays.toString(queue.toArray()));
            if(isCheck(queue)) result++;
            System.out.println("--------------------");
        }
        return result;
    }
    static boolean isCheck(Queue<Character> queue) { //해당 문자열이 올바른 괄호 문자열인지 체크
        boolean flag=  true;
        char first = queue.poll();
        for (int i = 1; i < queue.size(); i++) {
            if(first=='{' && queue.peek() != '}') flag = false;
            else if(first=='[' && queue.peek() != ']') flag = false;
            else if(first=='(' && queue.peek() != ')') flag = false;

            queue.offer(first);
            first = queue.poll();
        }
        queue.offer(first);
        return flag;
    }
}
