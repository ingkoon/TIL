package com.test;

import java.util.Stack;

public class Min {
    public static void main(String[] args) {
        String input = "baabaa";
        String input2 = "cacbba";
        System.out.println(solution(input));
    }

    static Stack<Character> stack;
    static int SIZE;
    static String solution(String input){
        stack = new Stack<>(); // 스택 초기화

        char[] chars = input.toCharArray(); // 문자열을 char 배열로 전환
        SIZE = chars.length; // 배열의 크기만큼 for문을 수행할 것이기 때문에 SIZE 변수 할당

        for (int i = 0; i < SIZE; i++) {
            if(stack.isEmpty()){ // stack이 빌 경우 값 추가
                stack.push(chars[i]);
                continue;
            }
            if(stack.peek() == chars[i]) // stack의 최상단 값과 현재 문자가 같을 경우 pop
                stack.pop();
            else
                stack.push(chars[i]); // stack에 값 추가
        }
        StringBuilder sb = new StringBuilder(); // stack값을 하나씩 빼가면서 StringBuilder에 추가
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        String answer = sb.reverse().toString(); // 역순으로 출력
        return answer;
    }
}
