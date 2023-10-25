package com.boj.boj1676;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        bf.close();

        int result = 0;
        while(n >= 5){
            result += n/5;
            n /= 5;
        }
        System.out.println(result);
    }
}
