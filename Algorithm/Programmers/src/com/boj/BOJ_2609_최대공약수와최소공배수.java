package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2609_최대공약수와최소공배수 {
    static int n, m;
    static int GCD, LCM;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);


        int a = Math.max(n, m);
        int b = Math.min(n, m);

        gcd(a, b);
        lcm();
        System.out.println(GCD);
        System.out.println(LCM);
    }

    static void gcd(int a, int b){
        if(a % b == 0) {
            GCD = b;
            return;
        }
        int tmp = b;
        b = a % b;
        a = tmp;
        System.out.println(a + " " + b);
        gcd(a, b);
    }

    static void lcm(){
        LCM = (n * m) / GCD;
    }
}
