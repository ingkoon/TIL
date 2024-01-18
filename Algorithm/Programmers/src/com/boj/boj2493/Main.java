package com.boj.boj2493;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 2493 G5 탑
 */
public class Main {
    static int n;
    static int[] towers;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        // n 초기화 및 배열 초기화
        n = Integer.parseInt(bf.readLine());

        towers = new int[n];
        result = new int[n];

        // 입력값 배열에 할당
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
        for (int i = 0; i < n; i++) {
            towers[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Tower> stack = new Stack<>();

        for (int i = n-1; i >= 0; i--) {
            int height = towers[i];
            if(stack.isEmpty()){ // 스택이 비어 있을 때
                stack.push(new Tower(height, i));
                continue;
            }
            if(stack.peek().height < height){
                while(!stack.isEmpty()) {
                    if(stack.peek().height > height)
                        break;
                    Tower tower = stack.pop();
                    result[tower.idx] = i + 1;
                }
            }
            stack.push(new Tower(height, i));

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
    static class Tower{
        int height;
        int idx;

        public Tower(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }
}

/**
 * 6 9 5 7 4가 주어졌을 때
 * 각각 0 0 2 2 4가 나와야 한다.
 */