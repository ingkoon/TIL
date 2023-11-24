package com.boj.boj6064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int m, n, x, y;
    static int SIZE;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) -1 ;
            SIZE = m * n;

            int result = -1;
            for(int i = x; i <= SIZE; i+=m){
              if(i % n == y){
                  result = i+1;
                  break;
              }
            }

            System.out.println(result);
        }
    }
}
