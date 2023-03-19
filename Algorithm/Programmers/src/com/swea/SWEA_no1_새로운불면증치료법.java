package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_no1_새로운불면증치료법 {
    static int T, n;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(bf.readLine());
            visited = new boolean[10];

            int size = 0;
            while(!isComplete()){
                size += n;
                char[] tmp = (size+"").toCharArray();
                for (char c : tmp) {
                    String num = c + "";
                    visited[Integer.parseInt(num)] = true;
                }
            }
            System.out.printf("#%d %d\n", t, size);
        }
    }

    static boolean isComplete(){
        for (boolean v : visited) {
            if(!v) return false;
        }
        return true;
    }
}
/*
5
1
2
11
1295
1692
*/
