package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_11053_가장긴증가하는부분수열 {
    static int a;
    static int[] arr;

    static List<Integer> seq;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        a = Integer.parseInt(bf.readLine());
        arr = new int[a];
        seq = new ArrayList<>();
        visited = new boolean[a];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < a; i++) {
            arr[i] = Integer.parseInt(st.nextToken()
            );
        }

        nPr(0);
        System.out.println(result);
    }

    public static void nPr(int cnt){
        if(cnt == a) {
            result = Math.max(result, cnt);
            return;
        }
        result = Math.max(result, cnt);

        for (int i = 0; i < a; i++) {
            if(visited[i]) continue;
            if(seq.isEmpty()) {
                visited[i] = true;
                seq.add(arr[i]);
                nPr(cnt+1);
            }
            else if(arr[i] > seq.get(seq.size()-1)){
                visited[i] = true;
                seq.add(arr[i]);
                nPr(cnt+1);
            }
            seq.remove(seq.get(seq.size()-1));
            visited[i] = false;
        }
    }
}
