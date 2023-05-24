package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259_팰린드롬수 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String tmp = bf.readLine();
            if(tmp.equals("0")) break;
            char[] arr = tmp.toCharArray();
            int left = 0;
            int right = arr.length-1;

            boolean flag = true;
            while (left < right){
                if(arr[left] == arr[right]) {
                    left++;
                    right--;
                    continue;
                }
                flag = false;
                break;
            }
            System.out.println(flag ? "yes" : "no");
        }
    }
}
