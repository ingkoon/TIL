package com.level2;

import java.util.Arrays;

public class PG_42860_조이스틱 {
    public static void main(String[] args) {
        String name = "JEROEN";
        System.out.println(solution(name));
    }

    static int solution(String name) {
        int answer = 0;

        char[] names = name.toCharArray();

        for (char c : names) {
            int start = c - 'A';
            int end = 'Z' - c + 1;
            System.out.println("right pattern is " + start + " reverse is " + end );
            int tmp = Math.min(start, end);
            answer += tmp;
        }

        if(name.length() == 3 && name.contains("A")){
            answer += names.length -2;
            return answer;
        }

        answer += names.length -1 ;
        return answer;
    }
}
