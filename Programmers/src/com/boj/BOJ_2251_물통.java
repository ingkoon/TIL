package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2251_물통 {
    static int A,B,C;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[] bottles = new int[] {0, 0, C};
        visited = new boolean[201];

        injection(bottles);
        for (int i = 0; i < visited.length; i++) {
            if(visited[i]) System.out.printf("%d ", i+1);
        }
    }

    static void injection(int[] bottles){
        if(visited[bottles[2]]) {
            return;
        }
        System.out.println(bottles[2]);
        visited[bottles[2]] = true;
        int[] tmpA = bottles.clone();
        int[] tmpB = bottles.clone();
        int[] Atmp = bottles.clone();
        int[] Btmp = bottles.clone();
        // 다른 항아리에 주입하는 과정 수행
        // 첫 번쨰 항아리에 물 담기
        tmpA[0] += tmpA[2] - A - tmpA[0] > 0 ? tmpA[2] - A - tmpA[0] : tmpA[2];
        tmpA[2] = Math.max(tmpA[2] - A - tmpA[0], 0);
        injection(tmpA);

        // 두 번째 항아리에 물 담기
        tmpB[1] += tmpB[2] - B - tmpB[1] > 0 ? tmpB[2] - B - tmpB[1] : tmpB[2];
        tmpB[2] = Math.max(tmpB[2] - B - tmpB[1], 0);
        injection(tmpB);
    }
}
