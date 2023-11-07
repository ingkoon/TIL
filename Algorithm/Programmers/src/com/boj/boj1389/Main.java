package com.boj.boj1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n, m;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int user1 = Integer.parseInt(st.nextToken());
            int user2 = Integer.parseInt(st.nextToken());

            list[user1].add(user2);
            list[user2].add(user1);
        }
        int[] results = new int[n+1];
        for (int i = 1; i <= n; i++) {
            results[i] = bfs(i);
        }

        int result = 1;

        for (int i = 2; i <= n; i++) {
            if(results[result] > results[i]){
                result = i;
            }
        }
        System.out.println(result);
    }

    static int bfs(int user){
        boolean[] visited = new boolean[n+1];
        int[] friends = new int[n+1];

        Queue<Friend> queue = new LinkedList<>();

        queue.add(new Friend(user, 0));
        visited[user] = true;
        while(!queue.isEmpty()){
            Friend friend = queue.poll();
            for(int i = 0; i < list[friend.user].size(); i++){
                int nextUser = list[friend.user].get(i);
                if(visited[nextUser]) continue;
                visited[nextUser] = true;
                friends[nextUser] = friend.count + 1;
                queue.offer(new Friend(nextUser, friend.count+1));
            }
        }
        int result = 0;
        for (int i = 1; i <=n; i++) {
            result += friends[i];
        }

        return result;
    }

    static class Friend{
        int user;
        int count;

        public Friend(int user, int count) {
            this.user = user;
            this.count = count;
        }
    }
}
