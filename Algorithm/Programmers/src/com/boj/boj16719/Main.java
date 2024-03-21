package com.boj.boj16719;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 16719 ZOAC
 */
public class Main {
    static int SIZE;
    static char[] title;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        title = bf.readLine().toCharArray();
        SIZE = title.length;
        visited = new boolean[SIZE];
        sb = new StringBuilder();
        printTitle(0, title.length-1);
        System.out.println(sb);
    }

    static void printTitle(int left, int right){
        if(left > right)
            return;
        int idx = left;
        for (int i = left; i <= right; i++) {
            if(title[idx] > title[i])
                idx = i;
        }
        visited[idx] = true;
        for (int i = 0; i < SIZE; i++) {
            if(visited[i])
                sb.append(title[i]);
        }
        sb.append("\n");
        printTitle(idx+1 , right);
        printTitle(left, idx-1);
    }
}

/*
0부터 탐색을 수행하면서 문자열을 compareTo를 통해 비교한다?
0일 경우, 값을 하나씩 삽입하면서 적은 부분을 추가한다.
예시 = ABAABC
 */