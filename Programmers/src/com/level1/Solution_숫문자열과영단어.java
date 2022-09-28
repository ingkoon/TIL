package com.level1;

public class Solution_숫문자열과영단어 {
    public static void main(String[] args) {
        System.out.println(solution("one4seveneight"));
    }
    public static int solution(String s) {
            String[] vocas = { "zero", "one", "two", "three", "four", "five", "six", "seven","eight", "nine"};
            int answer = 0;

            char[] spliiter = s.toCharArray();
            StringBuilder sb = new StringBuilder();
            StringBuilder result = new StringBuilder();

            for (char c : spliiter) {
                if(Character.isDigit(c)) result.append(c);

                else{
                    sb.append(c);
                }

                for (int i = 0; i < vocas.length; i++) {
                    if(vocas[i].equals(sb.toString())) {
                        result.append(i);
                        sb = new StringBuilder();
                        break;
                    }
                }
            }
            answer = Integer.parseInt(result.toString());
            return answer;
        }
}
