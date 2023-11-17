package com.boj.boj11054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int[] nums;
    static int[] lisDp;
    static int[] ldsDp;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        nums = new int[n+1];
        lisDp = new int[n+1];
        ldsDp = new int[n+1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            getLis(i);
            getLds(i);
        }

        int result = -1;
//        System.out.println(Arrays.toString(lisDp));
//        System.out.println(Arrays.toString(ldsDp));
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, (lisDp[i] + ldsDp[i]));
        }
        System.out.println(result - 1);
    }

    static int getLis(int num){
        if(lisDp[num] == 0) {
            lisDp[num] = 1;
            for (int i = num - 1; i >= 1; i--) {
                if (nums[i] < nums[num]) {
                    lisDp[num] = Math.max(lisDp[num], getLis(i) + 1);
                }
            }
        }
        return lisDp[num];
    }

    static int getLds(int num){
        if(ldsDp[num] == 0) {
            ldsDp[num] = 1;

            for (int i = num + 1; i <= n; i++) {
                if (nums[i] < nums[num]) {
                    ldsDp[num] = Math.max(ldsDp[num], getLds(i) + 1);
                }
            }
        }

        return ldsDp[num];
    }
}
/**
 * 이전 상태값을 가져온다?
 */