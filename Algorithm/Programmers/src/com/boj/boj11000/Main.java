package com.boj.boj11000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static TimeLine[] timeLines;
    static PriorityQueue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        queue = new PriorityQueue<>();
        n = Integer.parseInt(bf.readLine());
        timeLines = new TimeLine[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            timeLines[i] = new TimeLine(start, end);
        }

        Arrays.sort(timeLines, (o1, o2)-> o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start);

        queue.offer(timeLines[0].end);
        for (int i = 1; i < n; i++) {
            if(queue.peek() <= timeLines[i].start){
                queue.poll();
            }
            queue.offer(timeLines[i].end);
        }
        result = queue.size();
        System.out.println(result);
    }
    static class TimeLine{
        int start;
        int end;

        public TimeLine(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return "TimeLine{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
/*
8
1 8
9 16
3 7
8 10
10 14
5 6
6 11
11 12
 */