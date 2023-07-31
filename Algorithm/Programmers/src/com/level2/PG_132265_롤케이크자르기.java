package com.level2;

import java.util.HashMap;
import java.util.HashSet;

public class PG_132265_롤케이크자르기 {
    public static void main(String[] args) {
        int[] input = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(input));
    }

    static int SIZE;

    static int solution(int[] topping) {
        int answer = 0;
        SIZE = topping.length;
        HashSet<Integer> hashSet = new HashSet<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashSet.add(topping[0]);
        for (int i = 1; i < topping.length; i++) {
            hashMap.put(topping[i], hashMap.getOrDefault(topping[i],0)+1);
        }

        for (int i = 1; i < SIZE; i++) {
            hashSet.add(topping[i]);
            hashMap.put(topping[i], hashMap.get(topping[i])-1);
            if(hashMap.get(topping[i])==0){
                hashMap.remove(topping[i]);
            }
            if(hashSet.size() == hashMap.size())
                answer++;
        }
        
        return answer;
    }
}
