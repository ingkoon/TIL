package com.boj.boj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * BOJ 1021 S3 회전하는 큐
 */
public class Main {
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;


        for (int i = 0; i < m; i++) {
            int num = arr[i];

            int left = leftCount(deque, num);
            int right = rightCount(deque, num);

            if(left < right){
                result += left;
                while (deque.getFirst() != num){
                    deque.addLast(deque.removeFirst());
                }
            }else{
                result += right;
                while (deque.getFirst() != num){
                    deque.addFirst(deque.removeLast());
                }
            }

            deque.poll();
        }

        System.out.println(result);
    }

    static int leftCount(Deque<Integer> deque, int num){
        int cnt = 0;
        while (deque.getFirst() != num){
            deque.addLast(deque.removeFirst());
            cnt++;
        }
        for (int i = 0; i < cnt; i++) {
            deque.addFirst(deque.removeLast());
        }

        return cnt;
    }

    static int rightCount(Deque<Integer> deque, int num){
        int cnt = 0;
        while (deque.getFirst() != num){
            deque.addFirst(deque.removeLast());
            cnt++;
        }
        for (int i = 0; i < cnt; i++) {
            deque.addLast(deque.removeFirst());
        }
        return cnt;
    }
}
