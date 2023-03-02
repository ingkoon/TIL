package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class BOJ_1655_가운데를말해요 {
    static int n;
    static PriorityQueue<Integer> maxHeap;
    static PriorityQueue<Integer> minHeap;

    public static void main(String[] args) throws IOException {
        BufferedReader bf  = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        minHeap = new PriorityQueue<>(); // 중앙값보다 큰 값에 대해서는 최소힙을 구한다.
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1); // 중앙값보다 큰 값에 대해서는 최대 힙

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bf.readLine());
            if(maxHeap.size() == minHeap.size()) // 두 힙의 크기가 같다면
                maxHeap.offer(num); // 답을 갖고있는 최대힙을 넣는다.
            else
                minHeap.offer(num);

            if(isEmpty() && minHeap.peek() < maxHeap.peek()){ // 최소힙의 값이 최대힙의 값보다 크다면
                    int tmp = minHeap.poll(); // 최소힙의
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(tmp);
                }
           sb.append(maxHeap.peek() + "\n");
        }
        System.out.println(sb.toString());
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

