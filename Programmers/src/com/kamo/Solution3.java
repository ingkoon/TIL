package com.kamo;

class Solution3 {
    public int[] solution(String s, String[] times) {
        int[] store = new int[1000];
        store[0] = 1;
        int cnt = 1;
        int success =1;

        String[] tmp = s.split(":");

        int[] start = new int[tmp.length];

        // 정수 처리
        for(int i = 0; i < tmp.length; i++){
            start[i] = Integer.parseInt(tmp[i]);
        }

        int sYear =  start[0];
        int sMonth = start[1];
        int sDate = start[2];

        for(String time : times ){

            String[] t = time.split(":");
            int[] process = new int[t.length];
            // 정수 처리
            for(int i = 0; i < t.length; i++){
                process[i] = Integer.parseInt(t[i]);
            }

            // 초 계산
            int seconds = (start[5] + process[3]) % 60;
            int sUpper = (start[5] + process[3]) / 60;
            start[5] = seconds;
            // 분 계산
            int minutes = (start[4] + process[2] + sUpper) % 60 ;
            int mUpper = (start[4] + process[2] + sUpper) / 60 ;
            start[4] = minutes;
            // 시 계산
            int hours = (start[3] + process[1] + sUpper) % 24;
            int hUpper = (start[3] + process[1] + sUpper) / 24;
            start[3] = hours;
            // 일 계산
            int day = (start[2] + process[0] + hUpper) % 30;
            int dUpper = (start[2] + process[0] + hUpper) / 30;
            start[2] = day;
            // 월 계산
            int month = (start[1] + dUpper) % 12;
            int monthUpper = (start[1] + dUpper) / 12;
            start[1] = month;
            // 연 계산
            int year = start[0] + monthUpper;
            start[0] = year;

            if(hUpper + process[0] > 1) success = 0;
        }

        int count = (start[0] * 365 + start[1] * 30 +  start[2]) - (sYear * 365 + sMonth * 30 + sDate) + 1;
        int[] answer = {success, count};
        return answer;
    }
}