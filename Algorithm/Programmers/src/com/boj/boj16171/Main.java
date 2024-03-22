package com.boj.boj16171;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
BOJ 16171 나는 친구가 적다
 */
public class Main {
    static final String REGEX = "[^A-Za-z]";
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String incorrect = bf.readLine();
        String correct = bf.readLine();

        String renew = incorrect.replaceAll(REGEX, "");
        System.out.println(renew.contains(correct) ? 1 : 0);
    }
}
