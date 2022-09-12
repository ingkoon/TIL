package com.ssafy;

import java.util.Arrays;

public class CombiTest {
    static int [] p = {1, 2, 3, 4, 5};
    static int n;
    static int r;
    static int [] nums;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) {
        n = p.length;
        r = 3;
        nums = new int[r];
        visited = new boolean[n];
        npr(0, 0);
        System.out.println(count);
    }

    private static void npr( int start, int cnt) {
        if(cnt == r){
            count++;
            System.out.println(Arrays.toString(nums));
            return ;
        }
        for (int i = start; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            nums[cnt] = p[i];
            npr( i+1,cnt + 1);
            nums[cnt] = 0;
            visited[i] =false;
        }
    }
}
