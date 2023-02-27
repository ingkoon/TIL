package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ_13904_과제 {
    static int n, result;
    static PriorityQueue<Assignment> pq;
    static boolean[] deadlines;
    static int SIZE = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        pq = new PriorityQueue<>(new Comparator<Assignment>() {
            @Override
            public int compare(Assignment o1, Assignment o2) {
                return o2.score - o1.score;
            }
        });
        deadlines = new boolean[SIZE];
        for (int i = 0; i < n; i++) {
            String[] tmp = bf.readLine().split(" ");
            int deadline = Integer.parseInt(tmp[0]);
            int score = Integer.parseInt(tmp[1]);
            Assignment assignment = new Assignment(deadline, score);
            pq.offer(assignment);
        }

        System.out.println(Arrays.toString(pq.toArray()));
        int cnt = 0;
        for (Assignment assignment : pq) {
            int deadline = assignment.deadline;
            int score = assignment.score;

            if(deadlines[deadline]) continue;
            deadlines[deadline] = true;
            result += score;
        }
        System.out.println(result);
    }

    static class Assignment{
        int deadline;
        int score;
        public Assignment(int deadline, int score) {
            this.deadline = deadline;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Assignment{" +
                    "deadline=" + deadline +
                    ", score=" + score +
                    '}';
        }
    }
}
