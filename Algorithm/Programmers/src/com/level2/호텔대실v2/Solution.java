package com.level2.호텔대실v2;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(String[][] book_time) {

        int[][] bkt = new int[book_time.length][];

        for (int i = 0; i < book_time.length; i++) {
            bkt[i] = new int[] { parseTime(book_time[i][0]), parseTime(book_time[i][1]) + 10 };
        }

        Arrays.sort(bkt, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> que = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int ans = 0;

        for (int i = 0; i < bkt.length; i++) {
            while (!que.isEmpty() && que.peek()[1] <= bkt[i][0]) {
                que.poll();
            }
            que.add(bkt[i]);
            ans = Math.max(ans, que.size());
        }

        return ans;
    }

    protected int parseTime(String time) {

        String[] hhmm = time.split(":");
        int hour = Integer.parseInt(hhmm[0]), min = Integer.parseInt(hhmm[1]);
        return hour * 60 + min;

    }
}