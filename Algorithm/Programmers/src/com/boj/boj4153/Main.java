package com.boj.boj4153;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[3];
        StringTokenizer st  =new StringTokenizer(bf.readLine());

        for (int i = 0; i < 3; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while (arr[0] != 0 && arr[1] != 0 && arr[2] != 0){
            Arrays.sort(arr);
            int result = arr[0] * arr[0] + arr[1] * arr[1];

            if(result == arr[2] * arr[2])
                System.out.println("right");
            else
                System.out.println("wrong");

            st  =new StringTokenizer(bf.readLine());

            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
