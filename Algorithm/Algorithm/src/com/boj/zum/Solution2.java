package com.boj.zum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public static void main(String[] args) {
        int[][] data = {{1, 0, 3}, {2, 1, 3}, {3, 3, 2}, {4, 9, 1}, {5, 10, 2}};


        int[][] data2 = {{1, 2, 10}, {2, 5, 8}, {3, 6, 9}, {4, 20, 6}, {5, 25, 5}};
        System.out.println(Arrays.toString(solution(data2)));
    }
    static int[] solution(int[][] data){
        int[] answer = new int[data.length];

        // 1. 요청 시각 priority queue
        PriorityQueue<int[]> timeQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        /*
         2. 인쇄 요청 priority queue
            2.1. 대기 중인 문서 중 페이지 수가 적은 문서부터 인쇄
            2.2. 같은 문서가 있을 경우 먼저 요청된 문서
         */
        PriorityQueue<int[]> requestQueue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[2] == o2[2]) return o1[0] - o2[0];
                return o1[2] - o2[2];
            }
        });

        for (int[] request : data) {
            timeQueue.offer(request);
        }

        // 현재 위치를 카운트 하기위한 변수
        int cnt = 1;
        int[] request = timeQueue.poll();
        answer[0] =  request[0];


        int time = 0; // 현재 인쇄물의 시간을 측정하기위한 변수
        int wholeTime = 0; // 전체 시간을 측정하기 위한 변수

        while(!timeQueue.isEmpty()){
            if(wholeTime == timeQueue.peek()[1]){
                requestQueue.offer(timeQueue.poll());
            }

            wholeTime++;

            if(request[2] <= time) {
                if(requestQueue.size() == 0){
                    continue;
                }
                request = requestQueue.poll();
                answer[cnt] = request[0];
                time = 0;
                cnt++;
            }

            time++;
        }
        while(!requestQueue.isEmpty()){
            answer[cnt++] = requestQueue.poll()[0];
        }
        return answer;
    }
}


/*
1, 3, 2, 4, 5
 */