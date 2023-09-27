package com.level2;

public class PG_135807_숫자카드나누기 {
    public static void main(String[] args) {
        int[] arrayA = {10, 17};
        int[] arrayB = {5, 20};
        System.out.println(solution(arrayA, arrayB));
    }

    static int solution(int[] arrayA, int[] arrayB) {
        int SIZE_A = arrayA.length;
        int SIZE_B = arrayB.length;

        int gcdA = getArrayGcdV2(arrayA);
        int gcdB = getArrayGcdV2(arrayB);

        gcdA = !isCheck(arrayB, gcdA) ? gcdA : 0;
        gcdB = !isCheck(arrayA, gcdB) ? gcdB : 0;

        int answer = Math.max(gcdA, gcdB);

        return answer;
    }

    static int getArrayGcdV2(int[] array){
        if(array.length == 1)
            return array[0];
        int gcd = array[0];
        for(int num : array){
            gcd = getGcd(num, gcd);
        }
        return gcd;
    }

    static int getGcd(int x, int y){
        if(y == 0)
            return x;
        return getGcd(y, x % y);
    }

    static boolean isCheck(int[] array, int gcd){
        if(gcd == 1) return true;
        boolean flag = false;
        for(int num : array){
            if(num % gcd == 0)
                return true;
        }
        return flag;
    }
}
