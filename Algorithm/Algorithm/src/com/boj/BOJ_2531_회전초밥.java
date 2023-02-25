package com.boj;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BOJ_2531_회전초밥 {
    static int n, d, k, c;
    static int[] belt;
    static int result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();
        belt = new int[n];
        for (int i = 0; i < n; i++) {
            belt[i] = sc.nextInt();
        }

        for (int i = 0; i < n - k; i++) {
            int[] tmp = new int[k];
            for (int j = 0; j < k; j++) {
                tmp[j] = belt[i+j];
            }
            boolean flag = true;
//            for (int j = 0; j < k; j++) {
//                if(Collections.frequency(List(tmp), tmp[j]) > 1){
//                    flag = false;
//                    break;
//                }
//            }
            if(!flag) continue;
            else if(flag && !Arrays.asList(tmp).contains(c)) {
                Arrays.toString(tmp);
                result = Math.max(result, tmp.length + 1);
            } else {
                result = Math.max(result, tmp.length);
            }
        }

        System.out.println(result);
    }
}
