package com.boj.boj13913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 13913 G4 숨바꼭질 4
 */
public class Main {
    static int n, k, SIZE = 21;
    static boolean[] visited;
    static int[] reverse;
    static Queue<Loc> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        visited = new boolean[SIZE];
        reverse = new int[SIZE];

        sb = new StringBuilder();
        queue = new LinkedList<>();
        visited[n] = true;

        Loc tmp = new Loc(0, n);
        queue.offer(tmp);

        while (!queue.isEmpty()){
            Loc pLoc = queue.poll();

            if(pLoc.loc == k){
                sb.append(pLoc.seconds).append("\n");
                break;
            }

            for (int i = 0; i < 3; i++) {
                int next = 0;
                if(i == 0)
                    next = pLoc.loc + 1;
                else if (i == 1) {
                    next = pLoc.loc - 1;
                } else{
                    next = pLoc.loc * 2;
                }
                if(!isCheck(next) || visited[next])
                    continue;
                reverse[next] = pLoc.loc;
                visited[next] = true;
                queue.offer(new Loc(pLoc.seconds+1, next));

            }
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(k);
        int num = k;
        reverse[n] = -1;
        while(reverse[num] != -1){
            stack.push(reverse[num]);
            num = reverse[num];
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
    static boolean isCheck(int loc){
        return 0 <= loc && loc < SIZE;
    }

    static class Loc{
        int seconds;
        int loc;
        public Loc(int seconds, int loc) {
            this.seconds = seconds;
            this.loc = loc;
        }
    }
}
/**
 * 방문한 모든 거리를 출력해야 한다.
 */