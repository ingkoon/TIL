package com.level1;

import java.util.Arrays;

public class Solution_체육복 {
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 3};
        int[] reserve=  {1, 3, 5};

        System.out.println(solution(n, lost, reserve));
    }
    public static int solution(int n, int[] lost, int[] reserve) {

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int i = 0; i < lost.length; i++){
            for(int j = 0; j < reserve.length; j++){
                if(lost[i] == reserve[j]){
                    lost[i] = 0;
                    reserve[j] = 0;
                    break;
                }
            }
        }

        int answer = n - lost.length;
        for(int i = 0; i < reserve.length; i++){
            if(reserve[i]==0) continue;
            for(int j = 0; j < lost.length; j++){
                if(lost[j] == 0) continue;
                if(reserve[i]-1 == lost[j] || reserve[i]+1 == lost[j]){
                    lost[j] = 0;
                    break;
                }
            }
        }
        int tmp = 0;
        for(int t : lost){
            if(t == 0) tmp++;
        }
        System.out.println(Arrays.toString(lost));
        answer = n - (lost.length - tmp);
        return answer;
    }
}
