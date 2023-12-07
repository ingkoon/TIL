package com.boj.boj1041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long n;
    static int[] dice;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        dice = new int[6];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }
        if(n == 1 ){
            int idx = 0;
            int tmp = dice[0];

            for (int i = 1; i < 6; i++) {
                if(tmp < dice[i]){
                    idx = i;
                    tmp = dice[i];
                }
            }
            int result = 0;
            for (int i = 0; i < 6; i++) {
                if(i == idx)
                    continue;
                result += dice[i];
            }
            System.out.println(result);
        }else{
            long bottom = bottom();
            long top = top();
            System.out.println(bottom + top);
        }

    }

    /**
     * 가장 아래의 n * 4 - (n-2)^2 개의 블럭
     * @return result
     */
    static long bottom(){
        long result = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if(5 - i == j || i == j)
                    continue;
                result = Math.min(result, dice[i] + dice[j]);
            }
        }

        result = result * 4;

        if(n != 2){
            long tmp = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                tmp = Math.min(tmp, dice[i]);
            }
            result += (tmp *  (n - 2)) * 4;
        }
        return result * (n - 1);
    }

    static long top(){
        long result = Integer.MAX_VALUE;

        int[] head = {2, 3};
        int[] side = {0, 1, 4, 5};

        for (int i : head) {
            for (int j : side) {
                for (int k : side) {
                    if(j == k || 5 - k == j)
                        continue;
                    result = Math.min(result, dice[i] + dice[j] + dice[k]);
                }
            }
        }

        result = result * 4;
        if(n > 2){
            long tmp = Integer.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    if(5 - i == j || i == j)
                        continue;
                    tmp = Math.min(tmp, dice[i] + dice[j]);
                }
            }
            result += (tmp * (n - 2)) * 4;

            tmp = dice[0];

            for (int i = 1; i < 6; i++) {
                tmp = Math.min(tmp, dice[i]);
            }

            result += tmp * Math.pow((n-2), 2);
        }


        return result;
    }
}


/*
 3     3     3     3
----|-----|-----|----
1 2 | 2 1 | 1 2 | 2 1 = 36
1 2 | 2 1 | 1 2 | 2 1
1이 아닌 이상 가장 작은 부분은 이어진 두 면의 합이 가장 적은 것 4개 + 가장 작은 면 n개(n > 2일 때)
(n > 2일 때) 중간 부분도 마찬가지로 두 면의 합이 가장 적은 것 4개 + 가장 작은 면 n개
(n = 2일 때) 중간 부분도 마찬가지로 두 면의 합이 가장 적은 것 4개
맨 위는 ㄱ자 형태의 3 면의 합이 가장 적도록 구성 + n개의 주사위가 두 면의 합이 가장 적도록 구성 (n > 2일 때) + 가장 적은 면 (n - 2) ^ 2
(n = 2일 때) ㄱ자 형태의 세 면의 합이 가장 적은 주사위 * 4
 */