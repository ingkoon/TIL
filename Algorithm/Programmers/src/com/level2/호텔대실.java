package com.level2;
import java.util.*;
public class 호텔대실 {
    public static void main(String[] args) {
        String[][] input1 = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        System.out.println(solution(input1));
    }
    static int[] timeLine;
    static int SIZE = 1440;
    static int solution(String[][] book_time) {

        timeLine = new int[SIZE];
        int answer = 0;
        for(int i = 0; i < book_time.length; i++){
            String[] startString = book_time[i][0].split(":");
            String[] endString = book_time[i][1].split(":");

            int start = Integer.parseInt(startString[0]) * 60 + Integer.parseInt(startString[1]);
            int end = Integer.parseInt(endString[0]) * 60 + Integer.parseInt(endString[1]);

            System.out.println(start + " " + end);
            for(int j = start; j <= end; j++){
                timeLine[j]++;
            }
        }

        for(int i = 0; i < SIZE; i++){
            answer = Math.max(timeLine[i], answer);
        }

        return answer;
    }
/*
최소한의 객실을 제공해야한다.
겹치는 시간대가 있는지 파악해야한다.
*/
}

/*
import java.util.*;

class Solution {
    static PriorityQueue<TimeLine> queue;
    public int solution(String[][] book_time) {
        queue = new PriorityQueue<>(new Comparator<TimeLine>(){
            @Override
            public int compare(TimeLine o1, TimeLine o2){
                if(o1.start == o2.start)
                    return o1.end - o2.end;
                return o1.start - o2.start;
            }
        });

        for(String[] time : book_time){
            queue.offer(new TimeLine(time[0].split(":"), time[1].split(":")));
        }

        int answer = 0;
        return answer;
    }
    static class TimeLine{
        int start;
        int end;
        public TimeLine(String[] start, String[] end){
            this.start = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
            this.end = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        }
    }
}
/*
최소한의 객실을 제공해야한다.
겹치는 시간대가 있는지 파악해야한다.
*/
