package com.boj.boj11729;

import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        hanoi(n);
        System.out.println(cnt);
        System.out.println(sb.toString());
    }

    private static void hanoi(int n) {
        hanoi(n, 1,3,2);
    }

    private static void hanoi(int n, int a, int b, int c) {
        cnt++;
        if(n==1){
            sb.append(a + " " + b + "\n");
            return; //-> basis condition
        }
        hanoi(n-1, a, c, b);
        sb.append(a + " " + b + "\n");
        hanoi(n-1, c, b, a);

    }
}
