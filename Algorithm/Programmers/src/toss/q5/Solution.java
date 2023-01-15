package toss.q5;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        int[] tasks = {4, 1, 1, 1, 1, 2, 3};
        System.out.println(solution(tasks));
    }
    public static int solution(int[] tasks) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int t: tasks){
            if(!hashMap.containsKey(t)){
                hashMap.put(t, 1);
            }
            else{
                hashMap.put(t, hashMap.get(t) + 1);
            }
        }

        for(int t : hashMap.keySet()){
            if(hashMap.get(t) == 1)
                return -1;
        }
        return hashMap.size();
    }
}
