package com.kamo;

import java.util.*;
class Solution2 {
    public int solution(String[] id_list, int k) {
        int answer = 0;

        Map<String, Integer> map = new HashMap<>();
        for(String s : id_list){
            String[] tmp = s.split(" ");
            for(String user : tmp){
                map.put(user, 0);
            }
        }

        for(String s : id_list){
            String[] tmp = s.split(" ");
            HashSet<String> set = new HashSet<String>();
            for(String user : tmp){
                set.add(user);
            }
            for(String user : set){
                if(map.get(user) == k) continue;
                int c = map.get(user);
                map.replace(user, c+1);
            }
        }


        for(String key : map.keySet()){
            int val = map.get(key);
            answer += val;
        }

        return answer;
    }
}
