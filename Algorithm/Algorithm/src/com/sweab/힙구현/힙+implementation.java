package com.sweab.힙구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int TC = Integer.parseInt(str);

        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            Heap heap = new Heap();
            StringBuilder ret = new StringBuilder();
            for (int i = 0; i < N; i++) {
                String[] p = br.readLine().split(" ");
                int q = Integer.parseInt(p[0]);
                if (q == 1) {
                    int s = Integer.parseInt(p[1]);
                    heap.add(s);
                } else {
                    if (heap.isEmpty()) {
                        ret.append(-1).append(" ");
                    } else {
                        ret.append(heap.poll()).append(" ");
                    }
                }
            }
            System.out.println("#" + tc + " " + ret);
        }
    }
}


class Heap {
    int[] arr;
    int cnt = 0;

    Heap() {
        arr = new int[100001];
    }

    void add(int data) {
        arr[++cnt] = data;
        int now = cnt;
        while (now > 1) {
            int parent = getParent(now);
            if (arr[now] > arr[parent]) {
                int temp = arr[parent];
                arr[parent] = arr[now];
                arr[now] = temp;
                now = parent;
            } else {
                break;
            }
        }
    }

    void heapify() {
        int now = 1;
        while (getRight(now) <= cnt) {
            int larger = now;
            int left = getLeft(now);
            int right = getRight(now);
            if (arr[left] > arr[larger]) {
                larger = left;
            }
            if (arr[right] > arr[larger]) {
                larger = right;
            }
            if (larger != now) {
                int temp = arr[now];
                arr[now] = arr[larger];
                arr[larger] = temp;
                now = larger;
            } else {
                break;
            }
        }
    }

    int poll() {
        int max = arr[1];
        arr[1] = arr[cnt];
        arr[cnt] = 0;
        cnt--;
        heapify();
        return max;
    }

    boolean isEmpty() {
        return cnt == 0;
    }


    int getLeft(int parent) {
        return parent * 2;
    }

    int getRight(int parent) {
        return parent * 2 + 1;
    }

    int getParent(int child) {
        return child / 2;
    }

}