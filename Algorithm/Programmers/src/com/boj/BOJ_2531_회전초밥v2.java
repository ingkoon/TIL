package com.boj;

import java.util.*;

public class BOJ_2531_회전초밥v2 {
    static int n, d, k, c;
    static int[] belt;
    static int[] sushi;

    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();
        belt = new int[n];
        sushi = new int[d + 1];

        for (int i = 0; i < n; i++) {
            belt[i] = sc.nextInt();
        }

        int cnt = 0;
        for (int i = 0; i < k; i++) {
            if(sushi[belt[i]] == 0){
                cnt++;
            }
            sushi[belt[i]]++;
        }

        result = cnt;

        for (int i = 1; i < n; i++) {
            if(result <= cnt){
                if(sushi[c] == 0){
                    result = cnt + 1;
                } else{
                    result = cnt;
                }
            }

            int end = (i + k - 1) % n;
            if(sushi[belt[end]] == 0){
                cnt++;
            }
            sushi[belt[end]]++;


            sushi[belt[i-1]]--;
            if(sushi[belt[i - 1]] == 0){
                cnt--;
            }
        }
        System.out.println(result);
    }
}
