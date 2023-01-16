package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest {

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
        isSelected = new boolean[n+1];

        perm(0);
        System.out.println("총 경우의 수: " + totalCnt);

    }

    private static void perm(int cnt) {
        if(cnt == r){
            totalCnt ++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(isSelected[i]) continue;
            numbers[cnt] = i;
            isSelected[i] = true;
            perm(cnt + 1);
            isSelected[i] = false;
            numbers[cnt] = 0;
        }

    }
}
