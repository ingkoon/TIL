package toss.q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Solution {
    public static void main(String[] args) {
        System.out.println(solution("12223"));
        System.out.println(solution("111999333"));
    }

    public static int solution(String s) {
            int answer = 0;

            char[] tmp = s.toCharArray();
            ArrayList<Integer> result = new ArrayList<>();

            int cnt = 0;

            Stack<Character> stack = new Stack<>();

            for (char c : tmp) {
                //스택이 비었을 경우
                if (stack.isEmpty()) {
                    stack.push(c);
                    continue;
                }

                // 스택에 값이 있을 경우
                if (stack.peek() == c) {
                    stack.push(c);
                } else {
                    for (int j = 0; j < stack.size(); j++) {
                        stack.pop();
                    }
                    stack.push(c);
                }

                if (stack.size() == 3) {
                    System.out.println("stack.peek() = " + stack.peek());
                    result.add(stack.peek() - '0');
                    stack = new Stack<>();
                }
            }
            if(result.isEmpty())
                return -1;
            int val = Collections.max(result);
            answer = val * 100 + val* 10 + val;
            return answer;
    }
}