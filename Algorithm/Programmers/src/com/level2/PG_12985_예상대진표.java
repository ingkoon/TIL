package com.level2;

public class PG_12985_예상대진표 {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        System.out.println(solution(n, a, b));
    }
    static int solution(int n, int a, int b){
        int answer = 0;
        while(a!=b){
            answer++;
            a = calc(a);
            b = calc(b);
        }
        return answer;
    }
    static int calc(int num){
        if(num%2 ==0){
            return num /2;
        }
        return num/2+1;
    }
}
/*



1 2 3 4 5 6 7 8
 */