package com.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PG_92342_LV2_양궁대회 {
    public static void main(String[] args) {

    }

    static List<int[]> answer = new ArrayList<>();
    static int[] ryan;
    static int[] apeach;
    static int N;
    static int max = Integer.MIN_VALUE;
    public static int[] solution(int n, int[] info) {
        ryan = new int[11];
        N = n;
        apeach = info.clone();
//        DFS(0, 0);
        if (answer.isEmpty()) return new int[]{-1};
        Collections.sort(answer, (o1, o2) -> {
            for (int i = 10; i >= 0; i--) {
                if (o1[i] != o2[i]) return o2[i] - o1[i];
            }
            return 0;
        });
        return answer.get(0);
    }
}
