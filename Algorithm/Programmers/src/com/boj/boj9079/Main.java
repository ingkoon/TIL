package com.boj.boj9079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * BOJ 9079 동전 게임
 */
public class Main {
    static int T;
    static final int MAX = 512, MIN = 0;
    static boolean[] visited;

    static int[][] ops = {{6,7,8}, {3,4,5}, {0,1,2},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {2, 4, 6}, {0, 4, 8}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        for (int t = 0; t < T; t++) {
            int answer = -1;
            visited = new boolean[MAX];
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 3; i++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < 3; j++) {
                    if(st.nextToken().equals("H"))
                        sb.append(0);
                    else
                        sb.append(1);
                }
            }
            int bin = Integer.parseInt(sb.toString(), 2);
            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(bin, 0));
            while (!queue.isEmpty()){
                Node cur = queue.poll();

                if(cur.binaryValue == MAX-1 || cur.binaryValue == MIN){
                    answer = answer == -1 ? cur.cnt : Math.min(answer, cur.cnt);
                }

                for (int[] op : ops) {
                    int next = cur.binaryValue;
                    for (int j = 0; j < 3; j++) {
                        next ^= 1 << op[j];
                    }

                    if (visited[next])
                        continue;
                    visited[next] = true;
                    queue.offer(new Node(next, cur.cnt + 1));
                }
            }
            System.out.println(answer);
        }
    }

    static class Node{
        int binaryValue;
        int cnt;

        public Node(int binaryValue, int cnt) {
            this.binaryValue = binaryValue;
            this.cnt = cnt;
        }
    }
}
