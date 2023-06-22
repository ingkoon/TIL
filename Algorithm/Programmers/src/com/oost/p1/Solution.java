package com.oost.p1;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

public class Solution {
    static Map<Integer, Integer> map;

    public static void main(String[] args) {
        int[] input = {-999999, -999999};
        System.out.println(solution(input));
    }
    static int[] arr;
    static int SIZE = 2000001;
    static boolean solution(int[] A) {
        arr = new int[SIZE];
        // Implement your solution here
        for(int n : A){
            int num = n + 1000000;
            arr[num]++;
        }

        for(int i = 0; i < SIZE; i++){
            if(arr[i] == 0) continue;
            if(arr[i] %2 != 0 ) return false;
        }
        return true;
    }
}
