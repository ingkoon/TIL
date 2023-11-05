package com.boj.boj18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        array = new int[n];

        for (int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(array);

        int size = (int)Math.round(n * 0.15);
        double avg = 0;

        for (int i = size; i <= n - (size+1); i++) {
            avg += array[i];
        }

        int result = (int) Math.round(avg / (n - size * 2));
        System.out.println(result);
    }
}
