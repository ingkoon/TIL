package com.ssafy;

import java.lang.reflect.Array;
import java.util.Arrays;

public class prePermutation {
    static int[] p = {5,4,3,2,1};
    static int n = p.length;
    static int cnt;

    public static void main(String[] args) {
        do {
            cnt++;
            System.out.println(Arrays.toString(p));
            if(Arrays.equals(p, new int[]{3,2,1,5,4}))break;
        }while (pp(n-1));
        System.out.println(cnt);
    }

    private static boolean pp(int size) {
        int i = size;
        while(i>0&&p[i-1]<p[i]) i--;
        if(i ==0) return false;
        int j = size;
        while(p[i-1]<p[j])j--;
        int tmp = p[i-1];
        p[i-1] = p[j];
        p[j] = tmp;
        int k = size;
        while(i<k){
            tmp = p[i];
            p[i] = p[k];
            p[k] = tmp;
            i++;
            k--;

        }
        return true;

    }
}
