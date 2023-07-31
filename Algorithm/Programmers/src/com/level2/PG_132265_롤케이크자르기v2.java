package com.level2;

import java.util.HashMap;
import java.util.HashSet;

public class PG_132265_롤케이크자르기v2 {
    public static void main(String[] args) {
        int[] input = {1, 2, 1, 3, 1, 4, 1, 2};
        System.out.println(solution(input));
    }

    final static int TOPING_SIZE = 10001;
    static int SIZE;

    static int[] chulsoo;
    static int[] brother;
    static int solution(int[] topping) {
        int answer = 0;
        chulsoo = new int[TOPING_SIZE];
        brother = new int[TOPING_SIZE];
        SIZE = topping.length;
        chulsoo[topping[0]]++;
        for (int i = 1; i < topping.length; i++) {
           brother[topping[i]]++;
        }

        for (int i = 1; i < SIZE; i++) {
            chulsoo[topping[i]]++;
            brother[topping[i]] = brother[topping[i]] - 1 > 0 ? brother[topping[i]] : 0;
            if(isTrue())
                answer++;
        }
        
        return answer;
    }
    static boolean isTrue(){
        int chul = 0;
        int bro = 0;
        for (int i = 0; i < TOPING_SIZE; i++) {
            if(chulsoo[i] > 0)
                chul++;
            if(brother[i] > 0)
                bro++;
        }
        return chul == bro;
    }
}
