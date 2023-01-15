package com.level2;

public class Solution_문자열압축 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] test = new int[5];
        test[0] = s.solution("aabbaccc");
        test[1] = s.solution("ababcdcdababcdcd");
        test[2] = s.solution("abcabcdede");
        test[3] = s.solution("abcabcabcabcdededededede");
        test[4] = s.solution("xababcdcdababcdcd");
        for (int i : test) {
            System.out.println(i);
        }
    }
}

class Solution{
    public int solution(String s){
        int answer = s.length();
        String result = s;
        for (int i = 1; i <= s.length()/2; i++) {
            int cnt = 1;
            String zipWord = s.substring(0, i);
            StringBuilder sb = new StringBuilder();
            for (int j = i; j <= s.length(); j+=i) {
                String tmpWord  = j+i > s.length() ? s.substring(j, s.length()) :s.substring(j, j+i);
                if(zipWord.equals(tmpWord)) cnt++;
                else{
                    sb.append((cnt==1?"":cnt) + zipWord);
                    zipWord = tmpWord;
                    cnt = 1;
                }
            }
            sb.append(zipWord);
            result = result.length() < sb.length() ? result : sb.toString();
        }
        return result.length();
    }
}
