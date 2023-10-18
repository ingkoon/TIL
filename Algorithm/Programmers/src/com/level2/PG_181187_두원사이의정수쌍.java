package com.level2;

public class PG_181187_두원사이의정수쌍 {
    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;

        System.out.println(solution(r1, r2));
    }
    static long solution(int r1, int r2) {
        long answer = 0;

        long r1x = (long)Math.pow(r1,2);
        long r2x = (long)Math.pow(r2,2);

        long side =0;

        for(long i = 0;i <= r2; i++){

            long y2 = getY(r2x, i);
            long y1 = getY(r1x, i);

            if(Math.sqrt((r1x - Math.pow(i, 2))) % 1 == 0){ // y1이 정수일 경우
                side++;
            }
            System.out.println(y2 + " " + y1);
            answer += (y2 - y1) * 4;
        }
        answer += side*4 - 4; // 0인 부분 제거
        return answer;
    }

    static long getY(long rx, long i){
        return (long)Math.sqrt(rx - (long)Math.pow(i,2));
    }
}
