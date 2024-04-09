package com.boj.boj3273;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, x, result;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        numbers = new int[n];
        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        x = Integer.parseInt(bf.readLine());

        int start = 0;
        int end = n-1;

        while(start < end){
            if(numbers[start] + numbers[end] == x){
                result++;
                start++;
            }
            else if(numbers[start] + numbers[end] < x){
                start++;
            }
            else{
                end--;
            }
        }

        System.out.println(result);
    }
}

/*
1 2 3 5 7 9 10 11 12

1 2
1 3
1 5
1 7
1 9
1 10
1 11
1 12 o
2 12
2 11 o
3 11
3 10 o

 */


