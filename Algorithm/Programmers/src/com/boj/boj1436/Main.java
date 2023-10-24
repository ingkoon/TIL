package com.boj.boj1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(bf.readLine());

        int idx = 0;
        for (int i = 666; i < Integer.MAX_VALUE; i++) {
            if((i+"").contains("666"))
                idx++;
            if(idx == input){
                System.out.println(i);
                break;
            }
        }
    }
}
