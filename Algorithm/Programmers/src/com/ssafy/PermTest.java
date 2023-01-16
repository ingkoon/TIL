package com.ssafy;

import java.util.Arrays;

public class PermTest  {
    static int [] p = {1, 2, 3, 4};
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
        npr(0);
        System.out.println(count);
    }

    private static void npr( int cnt) {
        if(cnt == r){
            count++;
            System.out.println(Arrays.toString(nums));
            return ;
        }
        for (int i = 0; i < n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            nums[cnt] = p[i];
            npr( cnt + 1);
            nums[cnt] = 0;
            visited[i] =false;
        }
    }
}
