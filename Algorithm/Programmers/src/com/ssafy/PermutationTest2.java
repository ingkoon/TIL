package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest2 {

    static int n, r, totalCnt;
    static int[] numbers, input;
    static boolean[] isSelected;

    //npn : n개의 입력받은 수 중 n개를 모두 뽑아 순서적으로 나열한 것 (입력 수 1~100000)
    // npr : n개의 입력받은 수 중 r개를 모두뽑아 순서적으로 나열한 것 (1 <= r <= n)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        totalCnt = 0;

        input = new int[n];
        numbers = new int[r];
        isSelected = new boolean[n];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        perm(0);
        System.out.println("총 경우의 수: " + totalCnt);

    }

    private static void perm(int cnt) {
        if(cnt == r){
            totalCnt ++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 가능한 모든 수에 대해 시도(input 배열의 모든 수 시도)
        for (int i = 0; i < n; i++) {
            if(isSelected[i]) continue;
            numbers[cnt] = input[i];
            isSelected[i] = true;
            perm(cnt + 1);
            isSelected[i] = false;
        }

    }
}
