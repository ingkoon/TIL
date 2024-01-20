package com.boj.boj19598;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ 19598 G5 최소 회의실 개수
 */
public class Main {
    static int n;
    static PriorityQueue<Timeline> timelines;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        timelines = new PriorityQueue<>(Comparator.comparingInt(o -> o.time));

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            timelines.offer(new Timeline(start, false));
            timelines.offer(new Timeline(end, true));
        }

        int result = 0;
        int cnt = 0;
        while (!timelines.isEmpty()){
            Timeline timeline = timelines.poll();
            if(!timeline.isEnd){
                cnt++;
                result = Math.max(result, cnt);
                continue;
            }
            cnt--;
        }
        System.out.println(result);
    }

    static class Timeline implements Comparable<Timeline> {
        int time;
        boolean isEnd;

        public Timeline(int time, boolean isEnd) {
            this.time = time;
            this.isEnd = isEnd;
        }

        @Override
        public int compareTo(Timeline o) {
            return this.time - o.time;
        }
    }
}
/**
 *
 */