package com.boj.boj9019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int T, num, target;
    static boolean[] visited;
    static Queue<Register> queue;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            num = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());
            queue = new LinkedList<>();
            flag = false;

            visited = new boolean[10000];
            queue.offer(new Register("", num));

            while (!queue.isEmpty()){
                Register register = queue.poll();

                if(target == register.num){
                    System.out.println(register.command);
                    break;
                }

                getD(register.num, register.command);
                getS(register.num, register.command);
                getL(register.num, register.command);
                getR(register.num, register.command);
            }
        }
    }

    static void getL(int num, String command){
        int nextNum = (num % 1000) * 10 + num / 1000;
        if (visited[nextNum])
            return;
        visited[nextNum] = true;
        queue.offer(new Register(command+"L", nextNum));
    }

    static void getR(int num, String command){
        int nextNum = (num % 10) * 1000 + num / 10;
        if (visited[nextNum])
            return;
        visited[nextNum] = true;
        queue.offer(new Register(command+"R", nextNum));
    }

    static void getD(int num, String command){
        int nextNum  = num * 2 > 9999 ? num * 2 % 10000 : num * 2;
        if(visited[nextNum])
            return;
        visited[nextNum] = true;
        queue.offer(new Register(command + "D", nextNum));
    }

    static void getS(int num, String command){
        int nextNum = num - 1 < 0 ? 9999: num - 1;

        if(visited[nextNum])
            return;
        visited[nextNum] = true;
        queue.offer(new Register(command+"S", nextNum));
    }


    static class Register{
        String command;
        int num;

        public Register(String command, int num) {
            this.command = command;
            this.num = num;
        }
    }
}
