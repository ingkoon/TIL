package com.boj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BOJ_2606_바이러스 {
    static int n, m;
    static List<Integer>[] lists;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        lists = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int s = sc.nextInt()-1;
            int e = sc.nextInt()-1;
            lists[s].add(e);
            lists[e].add(s);
        }
        // 읽기 완료

        visited = new boolean[n];

        List<Integer> arr = new ArrayList<>();

        arr.add(1);
        visited[1] = true;
        int result = 0;
        while(!arr.isEmpty()){
            int tmp = arr.remove(arr.size()-1);
            for (Integer nextV : lists[tmp]) {
                if(visited[nextV]) continue;
                visited[nextV] = true;
                result++;
                arr.add(nextV);
            }
        }
        System.out.println(result);
    }
}
