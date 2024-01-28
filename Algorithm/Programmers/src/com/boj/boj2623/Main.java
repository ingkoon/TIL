package com.boj.boj2623;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static StringTokenizer st;

    static int[] musicians;
    static boolean[] visited;
    static List<Integer>[] sequence;
    static StringBuilder sb;

    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        musicians = new int[n+1];
        sequence = new ArrayList[n+1];
        visited = new boolean[n+1];

        sb = new StringBuilder();

        for (int i = 0; i <= n; i++) sequence[i] = new ArrayList<>();

        queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int seq = Integer.parseInt(st.nextToken());
            int before = -1;
            for (int j = 0; j < seq; j++) {
                int musician = Integer.parseInt(st.nextToken());
                if(j == 0){
                    before = musician;
                    continue;
                }
                sequence[before].add(musician);
                before = musician;
                musicians[musician] ++;
            }
        }


        run();
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if(musicians[i] != 0) {
                flag = true;
                break;
            }
        }

        System.out.println(flag ? 0 : sb);
    }

    static void inputQueue(){
        for (int i = 1; i <= n; i++) {
            if(musicians[i] == 0 && !visited[i]){
                queue.offer(i);
                visited[i] = true;
            }

        }
    }

    static void checkVertex(int musician){
        int size = sequence[musician].size();
        for (int i = 0; i < size; i++) {
            int next = sequence[musician].get(i);
            if(!visited[next]){
                musicians[next]--;
            }
        }
    }

    static void run(){
        inputQueue();
        while(!queue.isEmpty()){
            int musician = queue.poll();
            sb.append(musician).append("\n");
            checkVertex(musician);
            inputQueue();
        }
    }
}
/**
 * 최종적으로 다 돌았을 때, musicians에 0이 아닌 숫자가 남아있다면 0을 출력한다.
 */