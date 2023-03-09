package com.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PG_76502_괄호회전하기v2 {
    static  Queue<Character> queue;

    public static void main(String[] args) {
        String input = "[](){}";
        System.out.println(solution(input));
    }

    static int solution(String s) {
        char[] arr = s.toCharArray();
        queue = new LinkedList<>();

        int answer = 0;

        for(int i=0; i< arr.length; i++){
            queue.offer(queue.poll());
            int tmp = isCheck();
            if(tmp > answer) answer = tmp;
        }

        return answer;
    }
    static int isCheck() { //해당 문자열이 올바른 괄호 문자열인지 체크
        Object[] arr = queue.toArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(Object o : arr){
            char tmp = (char) o;
            if(stack.isEmpty()) {
                stack.push(tmp);
                continue;
            };

            if(tmp == ']' && stack.peek() == '['){
                stack.pop();
                result++;
            }
            else if(tmp == '}' && stack.peek() == '{'){
                stack.pop();
                result++;
            }
            else if(tmp == ')' && stack.peek() == '('){
                result++;
            }

            stack.push(tmp);
        }
        return result;
    }
}
