package com.ssafyb.binarysearch;

import java.util.TreeMap;

class Node {
    int idx;
    Node prev;
    Node next;
    Node(int idx) {
        this.idx = idx;
    }
}
public class Solution_긴사다리게임 {

    static final int N = 100;
    static final int MAX_NUM_NODE = 400210;
    static final int LAST_START_NODE = N;
    static final int FIRST_END_NODE = MAX_NUM_NODE - N - 5;

    static Node[] node = new Node[MAX_NUM_NODE];
    static int nodeCnt = 0;
    static TreeMap<Integer, Node> nodeMap[] = new TreeMap[N + 1];
    static TreeMap<Node, Integer> invNodeMap[] = new TreeMap[N + 1];

    public static void link(Node front, Node back) {
        front.next = back;
        back.prev = front;
    }

    public static void init() {
        for (int i = 0; i < MAX_NUM_NODE; i++) {
            node[i] = new Node(i);
        }
        for (int i = 1; i <= N; i++) {
            nodeMap[i] = new TreeMap<>();
            nodeMap[i].put(0, node[i]);
            nodeMap[i].put(1000000000, node[FIRST_END_NODE + i - 1]);
            link(node[i], node[FIRST_END_NODE + i - 1]);
        }
        nodeCnt = N + 1;
    }

    public static void add(int mX, int mY) {
        Node nowLeft = node[nodeCnt++];
        Node nowRight = node[nodeCnt++];

        Node prevLeft = nodeMap[mX].floorEntry(mY).getValue();
        Node prevRight = nodeMap[mX + 1].floorEntry(mY).getValue();

        Node nextLeft = prevLeft.next;
        Node nextRight = prevRight.next;

        link(prevLeft, nowRight);
        link(nowRight, nextRight);

        link(prevRight, nowLeft);
        link(nowLeft, nextLeft);

        nodeMap[mX].put(mY, nowLeft);
        nodeMap[mX + 1].put(mY, nowRight);
    }

    public static void remove(int mX, int mY) {
        Node nowLeft = nodeMap[mX].get(mY);
        Node nowRight = nodeMap[mX + 1].get(mY);

        Node prevLeft = nowRight.prev;
        Node prevRight = nowLeft.prev;

        Node nextLeft = nowLeft.next;
        Node nextRight = nowRight.next;

        link(prevLeft, nextLeft);
        link(prevRight, nextRight);

        nodeMap[mX].remove(mY);
        nodeMap[mX + 1].remove(mY);
    }

    public static int numberOfCross(int mID) {
        int ret = -1;
        Node now = node[mID];
        while (now.idx < node[FIRST_END_NODE].idx) {
            ret++;
            now = now.next;
        }
        return ret;
    }

    public static int participant(int mX, int mY) {
        Node now = nodeMap[mX].floorEntry(mY).getValue();
        while (now.idx > node[LAST_START_NODE].idx)
            now = now.prev;
        return now.idx;
    }
}