package com.level2;

public class PG_70129_이진변환반복하기 {
    public static void main(String[] args) {
        String input = "110010101001";
        System.out.println(solution(input));
    }
    static int[] solution(String s) {
        int zero = 0;
        int cnt = 0;
        while(s.length() > 1){
            int size = 0;
            StringBuilder sb = new StringBuilder();
            char[] arr = s.toCharArray();
            cnt++;
            for(char c : arr){
                if(c == '0') {
                    zero++;
                    continue;
                }
                size++;
            }
            s = Integer.toBinaryString(size);
        }
        int[] answer = new int[] {cnt, zero};
        return answer;
    }
}
