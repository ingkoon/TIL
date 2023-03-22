package com.gabia;

import java.util.*;

public class Solution1 {
    public static void main(String[] args) {
         String[] input  = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
         String[] input2 ={"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
        int K = 3;
        System.out.println(solution(K, input2));
    }
    static Data[] rank;
    static PriorityQueue<Data> queue;
    static int answer = 0;
    static int solution(int K, String[] user_score){
        queue = new PriorityQueue<>(new Comparator<Data>() {

            @Override
            public int compare(Data o1, Data o2){
                if(o1.score == o2.score) return 1;
             return o2.score - o1.score;
            }
        });

        rank = new Data[K];
        boolean flag = false;
        for (int i = 0; i < user_score.length; i++) {
            String[] parsedValue = user_score[i].split(" ");
            String id = parsedValue[0];
            int score = Integer.parseInt(parsedValue[1]);
            Data tmp = new Data(id, score);

            if(queue.size() == 0){
                queue.offer(tmp);
                continue;
            }
            boolean duplication = isDuplication(tmp);

            if(queue.size() < K && !duplication){
                queue.offer(tmp);
                continue;
            }

            if(queue.size() == K && !flag){
                answer = 3;
                for(int j = 0; j < K; j++){
                    rank[j] = queue.poll();
                }
                for (int j = 0; j < K; j++) {
                    queue.offer(rank[j]);
                }
                flag = true;
                continue;
            }

            queue.add(tmp);

            isCheck(K);

        }

        return answer;
    }
    static class Data{
        String id;
        int score;

        public Data(String id, int score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "id='" + id + '\'' +
                    ", score=" + score +
                    '}';
        }
    }
    static void isCheck(int k){
        boolean flag = true;

        Data[] tmp = new Data[k];
        for (int i = 0; i < k; i++) {
            tmp[i] = queue.poll();
        }

        for (int i = 0; i < k; i++) {
            queue.offer(rank[i]);
        }

        for (int i = 0; i < k; i++) {
            Data t = rank[i];
            Data r = tmp[i];
            if(!(t.id.equals(r.id))){
                rank[i] = r;
                flag = false;
            }
        }
        if(!flag) answer++;
    }

    static boolean isDuplication(Data pData){
        int tmp = queue.size();
        boolean flag = true;
        Data[] store = new Data[tmp];

        for (int i = 0; i < tmp; i++) {
            Data data = queue.poll();
            if(data.id == pData.id) {
                flag = false;
                data.score = Math.max(data.score,pData.score);
            }
            store[i] = data;
        }

        for (int i = 0; i < tmp; i++) {
            queue.offer(store[i]);
        }
        return flag;
    }
}
