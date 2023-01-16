package com.level1;

import java.util.HashSet;

public class Solution_포켓몬 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 2, 2};
        System.out.println(Solution(nums));

    }

    static int[] pocketmons;
    static boolean[] visited;
    static int r;
    static int result;

    static int Solution(int[] nums){
        pocketmons = new int[nums.length];
        visited = new boolean[nums.length];
        pocketmons = nums.clone();

        r = nums.length / 2;
        nPr(0);
        return result;
    }

    private static void nPr(int cnt) {
        if(cnt == r){
            HashSet<Integer> tmp = new HashSet<>();
            for (int i = 0; i < visited.length; i++) {
                if(visited[i]) tmp.add(pocketmons[i]);
            }
            result = Math.max(result, tmp.size());
            return;
        }

        for (int i = 0; i < pocketmons.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            nPr(cnt+1);
            visited[i] = false;
        }
    }
}
