package com.boj.boj1439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main { // 1439 뒤집기
    static String s;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        s = bf.readLine();
        char[] arr = s.toCharArray();

        boolean flag = arr[0] != '0'; // 1일 경우 true, 0일 경우 false;
        int one = flag ? 1 : 0;
        int zero = flag ? 0 : 1;
        for (char i : arr) {
            if(i == '0' && flag){
                flag = false;
                zero++;
            }
            if(i == '1' && !flag){
                flag = true;
                one++;
            }
        }
        result = Math.min(zero, one);

        System.out.println(result);
    }
}
/*
 */
