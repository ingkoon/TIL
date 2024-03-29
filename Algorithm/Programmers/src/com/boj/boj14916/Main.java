package com.boj.boj14916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        int result = 0;

        if(n == 1 || n == 3){
            System.out.println(-1);
        }
        else{
            result = n / 5;
            int spare = n % 5;
            if(spare%2 != 0){
                spare += 5;
                result = result == 0 ? 0 : result-1;
            }

            result += spare / 2;
            System.out.println(result);
        }
    }
}

/**
 * 5로 나누기를 했을 때 5로 나누어 떨어지거나 2의 배수로 나누어 떨어진다면 패스
 * 그것이 아니라면 몫을 하나 감소시킨다
 * 2로 나눈다. -> 끝~
 */
