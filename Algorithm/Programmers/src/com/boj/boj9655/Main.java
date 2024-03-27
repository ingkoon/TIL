package com.boj.boj9655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 9655 돌
 */
public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println(Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine()) % 2 == 1 ? "SK" : "CY");
    }
}

/*
남은 돌이 몇개인가에 따라서 승패가 갈린다.
5일 경우 1개를 가져가면 5(나)->4(상대)->3(나)->0 -> 내가 이김
따라서 가져갈 때 2의 배수만큼 남기면 내가 이긴다.-> 홀수는 상근, 짝수는 찬영

 */
