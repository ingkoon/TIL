package com.boj.boj2166;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static Node[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        long sumX = 0;
        long sumY = 0;
        arr = new Node[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            arr[i] = new Node(x, y);
        }

        for (int i = 0; i < n-1; i++) {
            Node first = arr[i];
            Node second = arr[i+1];
            sumX += first.x * second.y;
            sumY += first.y * second.x;
        }

        sumX += arr[n-1].x * arr[0].y;
        sumY += arr[n-1].y * arr[0].x;

        double result = 0.5 * Math.abs(sumX - sumY);
        System.out.printf("%.1f%n", result);
    }

    static class Node{
        long x;
        long y;
        public Node(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
