package com.gabia;

import java.util.*;

public class Solution1_2 {
    public static void main(String[] args) {
         String[] input  = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
         String[] input2 ={"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
        int K = 3;
        System.out.println(solution(K, input2));
    }
    static Data[] rank;
    static List<Data> list;
    static int answer = 0;
    static int solution(int K, String[] user_score){
        list = new ArrayList<>();

        rank = new Data[K];
        boolean flag = false;
        for (int i = 0; i < user_score.length; i++) {
            String[] parsedValue = user_score[i].split(" ");
            String id = parsedValue[0];
            int score = Integer.parseInt(parsedValue[1]);

            Data tmp = new Data(id, score);

            if(list.size() < K){
                if(isDuplication(tmp)) {
                    int mn = Math.min(list.size(), K);
                    sort();
                    isCheck(mn);
                    continue;
                }
                list.add(tmp);
                sort();
                answer ++;
                for(int j=0;j<list.size();j++){
                    rank[j]=list.get(j);
                }
                continue;
            }

            if(isDuplication(tmp)) {
                sort();
                isCheck(K);
                continue;
            }

            list.add(tmp);
            sort();
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
    }

    static void sort(){
        list.sort(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                if(o1.score == o2.score) return 1;
                return o2.score - o1.score;
            }
        });
    }
    static void isCheck(int k){
        boolean flag = true;

        Data[] tmp = new Data[k];

        for (int i = 0; i < k; i++) {
            tmp[i] = list.get(i);
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
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).id.equals(pData.id)){
                if(pData.score > list.get(i).score) {
                    list.set(i, pData);
                }
                return true;
            }
        }
        return false;
    }
}
