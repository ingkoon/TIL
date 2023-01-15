package com.level2;
import java.util.*;
public class Solution_기능개발 {
    class Solution {
        public int[] solution(int[] progresses, int[] speeds) {

            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i<speeds.length; i++){
                int tmp = (int) Math.ceil((100 - progresses[i]) / (double)speeds[i]);

                queue.offer(tmp);
            }

            List<Integer> result = new ArrayList<>();

            while(!queue.isEmpty()){
                int tmp = queue.poll();
                int cnt = 1;
                while(!queue.isEmpty()){
                    if(tmp < queue.peek()) {
                        break;
                    }
                    queue.poll();
                    cnt++;
                }
                result.add(cnt);
            }


            int[] answer = result.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();

            return answer;
        }
    }
}
