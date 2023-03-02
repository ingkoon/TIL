package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723_집합 {
    static int m;
    static int val;
    static String[] set = {"add", "remove", "check", "toggle", "all", "empty"};
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(bf.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            String calc = st.nextToken();

            if(calc.equals(set[0])){ // 추가 연산
                int num = Integer.parseInt(st.nextToken());
                val = val | (1 << num-1);
                continue;
            }
            if(calc.equals(set[1])){ // 제거 연산
                int num = Integer.parseInt(st.nextToken());
                val = val & ~(1 << num-1);
                continue;
            }
            if(calc.equals(set[2])){    // 체크 연산
                int num = Integer.parseInt(st.nextToken());
                String result = (val & (1 << num-1)) != 0? 1+"\n" : 0 + "\n";
                sb.append(result);
                continue;
            }
            if(calc.equals(set[3])){ //  toggle 연산
                int num = Integer.parseInt(st.nextToken());
                val = val ^ (1 << num-1);
                continue;
            }
            if(calc.equals(set[4])){ // 20까지의 값 추가
                val |= (~0);
                continue;
            }
            val &=  0;
        }

        System.out.println(sb.toString());
    }

}
