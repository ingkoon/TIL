package com.level2;
import java.util.*;

public class PG_131127_할인행사 {
    static Map<String, Integer> map;
    static int result;
    public static void main(String[] args) {
        String[] want = {"banana", "apple", "rice", "pork", "pot"};
        int[] number = {3, 2, 2, 2, 1};
        String[] discount =	{"chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};

        System.out.println(solution(want, number, discount));

    }
    static int solution(String[] want, int[] number, String[] discount) {
        map = new HashMap<>();

        for(String s : want){
            map.put(s, 0);
        }

        for(int i = 0; i < discount.length; i++){
            if(!map.containsKey(discount[i])){
                continue;
            }
            int cnt = map.get(discount[i]);
             map.put(discount[i], cnt+1);
             if(isCheck(want)) {
                 result = i;
                 break;
             }
        }

//        System.out.println(map.entrySet());
        checkSize(discount, want);
//        System.out.println(map.entrySet());

        return result;
    }

    static void checkSize(String[] discount, String[] want){
        int size = result;
        System.out.println(result);
        for(int i = 0; i < size; i++){
            System.out.println(map.entrySet());
            if(!isCheck(want))
                break;

            if(!map.containsKey(discount[i])){
                result--;
                continue;
            }
            int cnt = map.get(discount[i]);
            map.put(discount[i], --cnt);
            result--;
        }
    }

    static boolean isCheck(String[] want){ // 모든 상품을 구매할 수 있는지 체크하기 위한 메서드
        for(String s : want){
            if(map.get(s) == 0) return false;
        }
        return true;
    }
}
