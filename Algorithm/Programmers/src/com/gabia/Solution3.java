package com.gabia;

public class Solution3 {
    public static void main(String[] args) {
        int N = 3;
        int[] coffee_time = {4, 2, 2, 5, 3};

        System.out.println(solution(N, coffee_time));
    }

    static Order[] exit;
    static int[] answer;
    static int cnt;
    static int[] solution(int N, int[] coffee_time){
        answer = new int[N];
        exit = new Order[N];

        for(int i = 0; i< coffee_time.length; i++){
            int idx = 1;
            int tmp = coffee_time[i];
            Order order = new Order(idx++, tmp);
            for (int j = 0; j < N; j++) {
                if(exit[j]==null) exit[j] = order;
                continue;
            }
            if(isCheck(N)){
                pickCoffee(N);
            }
        }
        return answer;
    }

    static class Order{
        int idx;
        int value;

        public Order(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    static boolean isCheck(int n){
        for(int i = 0; i< n; i++){
            if(exit[i] == null) return false;
        }
        return true;
    }

    static void pickCoffee(int N){
        int idx = 0;
        Order value = exit[idx];
        for (int i = 1; i < N; i++) {
            if(exit[i].value > value.value){
                idx = i;
                value = exit[idx];
            }
        }

        for (int i = 0; i < N; i++) {
            exit[i].value = Math.abs(exit[i].value - value.value);
            if(exit[i].value == 0) {
                answer[cnt++] = exit[i].idx;
                exit[i] = null;
            }
        }
    }
}
