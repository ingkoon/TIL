package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수{
    static int n;
    static int[] nums;

    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        nums = new int[n];
        stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]){
                nums[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()){
            nums[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i] + " ");
        }
        System.out.println(sb.toString());
    }
}

/*
자신의 오른쪽에 있는 수 중 자신보다 큰 수를 찾되 가장 왼쪽에 있는 수를 가져올 수 있도록 하자.

 */