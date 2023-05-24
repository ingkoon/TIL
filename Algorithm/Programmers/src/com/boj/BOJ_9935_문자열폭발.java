package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9935_문자열폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input = bf.readLine();
        String boot = bf.readLine();

        Stack<Character> stack = new Stack<>();

        char[] inputArr = input.toCharArray();
        char[] bootArr = boot.toCharArray();

        for (int i = 0; i < inputArr.length; i++) {
            stack.push(inputArr[i]);

            boolean flag = false;
            if(stack.size() >= bootArr.length){
                for (int j = 0; j < bootArr.length; j++) {
                    if(stack.get(stack.size() - bootArr.length + j) != bootArr[j])
                        flag = true;
                }
                if(!flag) {
                    for (int j = 0; j < bootArr.length; j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (Character c : stack) {
            sb.append(c);
        }

        System.out.println(sb.toString().equals("") ? "FRULA" : sb);
    }
}
