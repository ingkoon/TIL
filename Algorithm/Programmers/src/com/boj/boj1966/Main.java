package com.boj.boj1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T;
    static int[] important;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int cnt = Integer.parseInt(st.nextToken());
            int loc = Integer.parseInt(st.nextToken());

            important = new int[10];
            Queue<Print> queue = new LinkedList<>();

            st = new StringTokenizer(bf.readLine());
            int max = 0;
            for (int i = 0; i < cnt; i++) { // queue에 데터 삽입
                int tmp = Integer.parseInt(st.nextToken());
                important[tmp]++;
                max = Math.max(tmp, max);
                queue.offer(new Print(i, tmp));
            }

            int result = 0;

            while(!queue.isEmpty()){
                Print print = queue.poll();

                if(important[max] != 0 && print.imp!=max){
                    queue.offer(print);
                    continue;
                }

                if(print.loc == loc){
                    result++;
                    System.out.println(result);
                    break;
                }

                important[max]--;
                result++;

                if(important[max] == 0){
                    for (int i = max; i >= 1; i--) {
                        if(important[i] != 0){
                            max = i;
                            break;
                        }
                    }
                }
            }
        }
    }

    static class Print{
        int loc;
        int imp;
        public Print(int loc, int imp) {
            this.loc = loc;
            this.imp = imp;
        }
    }
}
