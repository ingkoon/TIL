package com.level2;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PG_17683_방금그곡 {
    public static void main(String[] args) {
        String m = "ABCDEFG";
        String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};

//        "CC#BCC#BCC#BCC#B", ["03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"]

        String m1 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos1 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        System.out.println(solution(m, musicinfos));
        System.out.println(solution(m1, musicinfos1));
    }

    static String solution(String m, String[] musicinfos){
        String answer = "";
        for(String musicInfo : musicinfos){
            String[] info = musicInfo.split(",");
            System.out.println(Arrays.toString(info));

            String[] start = info[0].split(":");
            String[] end = info[1].split(":");

            int hour = Integer.parseInt(start[0]) - Integer.parseInt(end[0]); // 시간 구하기
            int minute = hour != 0 ? 60 - Integer.parseInt(start[1]) + Integer.parseInt(end[1]) :  Integer.parseInt(end[1]) + Integer.parseInt(start[1]); // 분 구하기
            if(minute < 60 && hour > 0){ // 다음 시로 넘어갔을 때 -1
                hour -= 1;
            }
            int time = hour * 60 + minute; // 시를 분으로 전환


            String[] rhythm = info[3].split("");// 리듬을 쪼갠다.
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i< time; i ++){
                String r = rhythm[i%rhythm.length];
                if(r.equals("#")) {
//                    sb.delete()
                    r =  rhythm[i%rhythm.length-1] + r;
                }
                sb.append(r);
            }
            System.out.println("music is " + sb.toString());
        }
        return answer;
    }
}
