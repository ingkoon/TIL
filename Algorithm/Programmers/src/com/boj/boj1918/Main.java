package com.boj.boj1918;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
    static Map<Character, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        map = new HashMap<>(); // 맵 초기화
        setMap(); // 우선순위 초기화

        char[] expression = bf.readLine().toCharArray(); // 중위표현식 입력
        Stack<Character> stack = new Stack<>(); // 스택 추가
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length; i++) {
            if(stack.isEmpty()){
                if(map.containsKey(expression[i])){
                    stack.add(expression[i]);
                    continue;
                }else{
                    sb.append(expression[i]);
                    continue;
                }
            }
            if(expression[i] == ')'){ // ')'일 경우 '('가 나올때까지 반복
                while(stack.peek() == '(')
                    sb.append(stack.pop());
                stack.pop(); // '('도 추출
            }
            else if(!map.containsKey(expression[i])){ // 피연산자일 경우 출력
                sb.append(expression[i]);
            }
            else{
                while(map.get(stack.peek()) >= map.get(expression[i])){ // 우선순위가 높은 연산자가 나올때까지 반복
                    sb.append(stack.pop());
                }
                stack.push(expression[i]);
            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
    static void setMap(){
        map.put('+', 2);
        map.put('-', 2);
        map.put('*', 1);
        map.put('/', 1);
        map.put('%', 1);
        map.put('(', 0);
    }
}
