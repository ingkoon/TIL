package com.kamo;

class Solution1{
    int answer = 0;
    static int SIZE = 366;
    public int solution(int[][] flowers) {
        int[] days = new int[SIZE];

        for(int[] f : flowers){
            for(int i = f[0]; i < f[1]; i++){
                days[i] += 1;
            }
        }
        int tmp = 0;
        boolean flag = false;

        for(int i=0; i< SIZE; i++){
            if(days[i]>0) answer++;
        }
        return answer;
    }
}