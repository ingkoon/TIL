package com.est.problem3;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String input1 = "09:55";
        String[] input2 = {"13:25~14:01", "09:56~13:25", "20:08~20:15"};

        String input3 = "23:00";
        String[] input4 = {"22:30~23:40", "23:05~00:45"};

        System.out.println(solution(input3, input4));
    }

    static boolean[] timeLine;
    static int SIZE = 1441;
    static String solution(String noti_time, String[] do_not_disturb) {
        timeLine = new boolean[SIZE]; // 타임라인 초기화

        for (String disturb : do_not_disturb) { // 알람 방지 시간대 설정
            String[] time = disturb.split("~");

            String[] startArr = time[0].split(":"); // 시작 시간
            String[] endArr = time[1].split(":"); // 종료 시간

            int startHour = Integer.parseInt(startArr[0]) * 60;
            int startMinutes = Integer.parseInt(startArr[1]);

            int endHour = Integer.parseInt(endArr[0]) * 60;
            int endMinutes = Integer.parseInt(endArr[1]);

            int start = startHour + startMinutes;
            int end = endHour + endMinutes;

            System.out.println(start + " " + end);
            if(end < start){  // 자정이 넘어갈 경우
                for (int i = start; i < timeLine.length; i++) {
                    timeLine[i] = true;
                }
                for (int i = 0; i < end; i++) {
                    timeLine[i] = true;
                }
            }

            for (int i = start; i < end; i++) {
                timeLine[i] = true;
            }
        }

        String[] notiArr = noti_time.split(":"); // 시작 시간
        int notiHour = Integer.parseInt(notiArr[0]) * 60;
        int notiMinutes = Integer.parseInt(notiArr[1]);
        int notiTime = notiHour + notiMinutes;

        int result = -1;

        for(int i = notiTime; i < SIZE; i++){
            if(!timeLine[i]){
                result= i;
                break;
            }
        }
        if(result == -1){
            for (int i = 0; i < notiTime; i++) {
                if (!timeLine[i]) {
                    result = i;
                    break;
                }
            }
        }

        if(result == -1)
            return "impossible";

        int hour = result / 60;
        int minutes = result % 60;

        String answerHour = String.valueOf(hour);
        String answerMinutes = String.valueOf(minutes);
        if(hour < 10){
            answerHour = "0" + answerHour;
        }
        if(minutes < 10){
            answerMinutes = "0" + answerMinutes;
        }
        return answerHour + ":" + answerMinutes;
    }
}
