package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_14621_나만안되는연애 {
    static int n, m;
    static int result;
    static int[] minValue;
    static char[] gender;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        minValue = new int[n];
//        gender = bf.readLine().split(" ");
        System.out.println(Arrays.toString(gender));
    }
}
