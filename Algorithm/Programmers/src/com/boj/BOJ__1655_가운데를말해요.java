package com.boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class BOJ__1655_가운데를말해요 {
    static int n;
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());
            if(maxHeap.size() == minHeap.size())
                maxHeap.offer(num);
            else
                minHeap.offer(num);

            if(isEmpty()){
                if(minHeap.peek() < maxHeap.peek()){
                    int tmp = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
            }
            System.out.println(maxHeap.peek());
        }
    }
    static boolean isEmpty(){
        return !maxHeap.isEmpty() && !minHeap.isEmpty();
    }
}
/*
-99 1 2 5 5 7 10
1일 때 1
2일때 1
3일 때 2
4일때 2

pq에서 값을 한번에 빼는법?
pq는 끝값만 가져올 수 있다.
중간값을 가져오려면?
중간까지 pop을 하고 다시 add? -> 아니다. 맞나?

1일 때 [1] 1
2일 때 [1], [5] 이므로 1
3일 때 [1, 2], [5]이므로 1을 빼고 2 가된다. 2, 5
4일 떄 [1, 2], [5, 10]이므로 1을 뺴고 2가 되어야한다. 2, 5
5일 때 -99, 1, 2, 5, 10 이므로 2가 되어야 한다. 2, 5
6일 때 -99, 1, 2, 5, 7, 10 이므로 2가 되어야 한다. 2, 5
7의 경우 -99, 1, 2, 5, 5 ,7, 10 이므로 5가 되어야 한다. 5, 5

pop을 했을 떄 해당 숫자가 left right 의 사이값이면 left에 할당? 무슨 미친소리야
힙을 두개만들어서 최대힙/최소힙을 둔다?
그럼 어떻게?
*/