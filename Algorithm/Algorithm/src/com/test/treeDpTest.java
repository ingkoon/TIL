package com.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class treeDpTest {
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        arr = new int[4];
        visited = new boolean[4];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(0,0));
        visited[0] = true;

        ArrayList<Integer>[] linkedList = new ArrayList[4];
        for (int i = 0; i < 4; i++) {
            linkedList[i] =new ArrayList<>();
        }

        linkedList[0].add(1);
        linkedList[0].add(2);
        linkedList[1].add(3);

        int result = 0;

        while(!queue.isEmpty()){
            Node pn = queue.poll();
            int size = linkedList[pn.e].size();

            arr[pn.e] = pn.val;

            for (int i = 0; i < size; i++) {
                if(visited[linkedList[pn.e].get(i)]) continue;
                visited[linkedList[pn.e].get(i)] = true;

                queue.offer(new Node(linkedList[pn.e].get(i), pn.val + 1));
            }
        }
        System.out.println(Arrays.toString(arr));
    }


    static class Node{
        int e;
        int val;
        public Node(int e, int val) {
            this.e = e;
            this.val  = val;

        }
    }
}
