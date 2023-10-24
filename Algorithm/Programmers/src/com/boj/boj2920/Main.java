package com.boj.boj2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int[] arr = new int[8];

        for (int i = 0; i < 8; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            arr[i] = tmp;
        }

        System.out.println(checkArr(arr));
    }

    static String checkArr(int[] arr){
        boolean isAscending = true;
        boolean isDescending = true;
        String result = "";
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i-1] != 1){
                isAscending = false;
            }
        }

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] - arr[i-1] != -1){
                isDescending = false;
            }
        }
        if(isAscending)
            result = "ascending";
        else if(isDescending)
            result = "descending";
        else
            result = "mixed";

        return result;
    }
}
