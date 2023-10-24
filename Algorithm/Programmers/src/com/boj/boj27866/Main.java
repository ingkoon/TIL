package com.boj.boj27866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int idx = Integer.parseInt(bf.readLine());

        System.out.println(input.charAt(idx-1));
    }
}
