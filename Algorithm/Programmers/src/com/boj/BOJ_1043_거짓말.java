package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1043_거짓말 {
    static int n, m;
    static boolean[] visited; // 진실을 아는 사람인지 확인
    static boolean[] trueParty;

    static Queue<Integer> queue;
    static List<Integer>[] parties;

    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken()); // 사람의 수
        m = Integer.parseInt(st.nextToken()); // 파티의 수

        visited = new boolean[n + 1];
        trueParty = new boolean[m];

        parties = new ArrayList[m]; // 파티를 의미하는 HashSet 추가
        queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            parties[i] = new ArrayList<>();
        }

        st= new StringTokenizer(bf.readLine()); // 진실을 아는 사람의 수
        int count = Integer.parseInt(st.nextToken());

        if(count != 0){ // 진실을 아는 사람이 0이 아닐 경우
            for (int i = 0; i < count; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < m; i++) { // 파티의 수만큼 반복 수행
            st = new StringTokenizer(bf.readLine());
            int size = Integer.parseInt(st.nextToken()); //  인원수 할당
            for (int j = 0; j < size; j++) {
                parties[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        while (!queue.isEmpty()){
            int p = queue.poll();
            visited[p] = true;
            for (int i = 0; i < parties.length; i++) {
                if(parties[i].contains(p)){
                    trueParty[i] = true;
                    for(int j = 0; j < parties[i].size(); j ++){
                        int tmp = parties[i].get(j);
                        if(visited[tmp]) continue;
                        queue.offer(tmp);
                    }
                }
            }
        }

        for (int i = 0; i < trueParty.length; i++) {
            if(!trueParty[i]) result++;
        }
        System.out.println(result);
    }
}
