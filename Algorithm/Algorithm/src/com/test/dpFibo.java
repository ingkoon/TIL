package com.test;

import java.util.Arrays;
import java.util.Scanner;

public class dpFibo {
    static int n;
    static int[] fibos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        fibos = new int[n];

        System.out.println(calc());
    }

    static int calc(){
        fibos[0] = 0;
        fibos[1] = 1;

        for (int i = 2; i < n; i++) {
            fibos[i] = fibos[i-1] + fibos[i-2];
        }

        System.out.println(Arrays.toString(fibos));
        return fibos[n-1];
    }
}
