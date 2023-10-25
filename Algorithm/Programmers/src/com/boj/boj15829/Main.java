package com.boj.boj15829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(bf.readLine());
        char[] chars = bf.readLine().toCharArray();
        long tmp = 1;
        long result = 0;
        for (int i = 0; i < l; i++) {
            result += (chars[i] - 96) * tmp;
            tmp = (tmp * 31) % 1234567891;
        }
        System.out.println(result);
    }
}
