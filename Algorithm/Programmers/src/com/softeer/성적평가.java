package com.softeer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 성적평가 {
    static int n;
    static int[][] score;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        score = new int[n+1][n];
        Rank[] arr = new Rank[n];

        for (int i = 0; i < n; i++) {

            String[] s = bf.readLine().split(" ");

            for (int j = 0; j < s.length; j++) {
                arr[i] = new Rank(j , Integer.parseInt(s[j]));
            }

            Arrays.sort(arr, new Comparator<Rank>() {
                @Override
                public int compare(Rank o1, Rank o2) {
                    return o2.score - o1.score;
                }
            });
            int cnt = 0;
            int prev = 0;
            int tmp = 0;
            for (int j = 0; j < n; j++) {
                Rank r = arr[j];
                if(prev == 0) {
                    score[i][r.member] = ++cnt;
                    prev = r.score;
                    continue;
                }
                if(prev == r.score){
                    score[i][r.member] = cnt;
                    tmp++;
                    continue;
                }
                score[i][r.member] = ++cnt + tmp;
                tmp = 0;
            }
        }

        Rank[] resultSum = new Rank[n];
        for(int i = 0; i < n; i++){
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += score[j][i];
            }
            resultSum[i] = new Rank(i, sum);
        }

        for (Rank rank : resultSum) {
            System.out.printf("%d" , rank.score);
        }

        System.out.println();
        Arrays.sort(resultSum, new Comparator<Rank>() {
            @Override
            public int compare(Rank o1, Rank o2) {
                return o1.score - o2.score;
            }
        });

        int cnt = 0;
        int prev = 0;
        int tmp = 0;
        for (int i = 0; i < n; i++) {
            Rank r = resultSum[i];
            if(prev == 0) {
                score[n][r.member] = ++cnt;
                prev = r.score;
                continue;
            }
            if(prev == r.score){
                score[n][r.member] = cnt;
                tmp++;
                continue;
            }
            score[n][r.member] = ++cnt + tmp;
            tmp = 0;
        }

        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ", score[i][j]);
            }
            System.out.println();
        }
    }

    static class Rank{
        int member;
        int score;

        public Rank(int member, int score) {
            this.member = member;
            this.score = score;
        }
    }
}

/*
현주는 N명의 인원이 참여하는 프로그래밍 스터디 그룹을 이끌고 있다.

현주는 스터디를 위해 대회를 세 개 개최하였고, 모든 구성원이 각 대회에 참여하였다.
참가자는 각 대회에서 0 이상 1,000 이하의 정수인 점수를 얻는다. 한 대회에서 둘 이상의 참가자가 동점이 나오는 경우도 있을 수 있다.

현주는 각 대회별 등수 및 최종 등수를 매기고 싶다.
등수는 가장 점수가 높은 사람부터 1등, 2등, ···, N등의 순서대로 붙는다.
만일 동점이 있을 경우 가능한 높은 (등수의 수가 작은) 등수를 부여한다.
즉, 점수가 내림차순으로 10,7,6,6,4의 순서일 경우, 6점을 받은 두 사람은 공동 3등이 되고, 그 다음 순서인 4점을 받은 사람은 5등이 된다.
이 규칙을 다르게 표현하면 다음과 같다: 각 사람마다 “나보다 점수가 큰 사람”의 수를 세어 1을 더한 것이 자신의 등수가 된다.
대회별 등수는 각 대회에서 얻은 점수를 기준으로 하며 최종 등수는 세 대회의 점수의 합을 기준으로 한다.

각 참가자의 대회별 등수 및 최종 등수를 출력하는 프로그램을 작성하시오.
 */