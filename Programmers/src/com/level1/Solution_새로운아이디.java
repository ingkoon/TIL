package com.level1;

import java.util.Arrays;

public class Solution_새로운아이디 {
    public static void main(String[] args) {
        Solution_새로운아이디 s = new Solution_새로운아이디();
        System.out.println(s.solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(s.solution("z-+.^."));
        System.out.println(s.solution("=.="));
        System.out.println(s.solution("123_.def"));
        System.out.println(s.solution(	"abcdefghijklmn.p"));
    }
        public String solution(String new_id) {
            String answer = "";
            answer = step7(step6(step5(step4(step3(step2(step1(new_id)))))));
            return answer;
        }
        // 1단계
        public static String step1(String new_id){
            return new_id.toLowerCase();
        }
        // 2단계
        public String step2(String new_id) {
            return new_id.replaceAll("[~!@#$%^&*()=+\\[{\\]}:?,<>/]", "");
        }
        // 3단계
    public String step3(String new_id){
//        String result = "";
//        char[] tmp = new_id.toCharArray();


//        for (char c : tmp) {
//            if (result.length()==0){
//                result += c;
//                continue;
//            }
//            if (result.charAt(result.length()-1) == '.' && c == '.') continue;
//            result+=c;
//        }
        for (int i = new_id.length()-1; i >=2; i--) {
            String dots = ".".repeat(i);
            if(new_id.contains(dots)) {
                new_id = new_id.replace(dots,".");
            }
        }
        return new_id;
    }

    public String step4(String new_id){
        if(new_id.length() == 1 && new_id.charAt(0) == '.') return "";

        if (new_id.charAt(new_id.length()-1) == '.') new_id = new_id.substring(0, new_id.length()-1);
        if(new_id.charAt(0) == '.') new_id = new_id.substring(1,new_id.length());

        return new_id;
    }

    public String step5(String new_id){
        if(new_id.equals("")) return "a";
        return new_id;
    }

    public String step6(String new_id){
        if (new_id.length() >15)
            new_id = new_id.substring(0, 15);
        if(new_id.charAt(new_id.length()-1)== '.')
            return new_id.substring(0, new_id.length()-1);
        return new_id;
    }

    public String step7(String new_id){
        if(new_id.length()<=2){
            for (int i = 0; i <= 3 - new_id.length(); i++) {
                new_id += new_id.charAt(new_id.length()-1);
            }
        }
        return new_id;
    }
}
