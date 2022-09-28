package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {

    static int n, r, totalCnt;
    static int[] numbers, input; //조합의 결과와 n개수를 입력받기 위한 배열 두개 선언

    //npn : n개의 입력받은 수 중 n개를 모두 뽑아 순서적으로 나열한 것 (입력 수 1~100000)
    // npr : n개의 입력받은 수 중 r개를 모두뽑아 순서적으로 나열한 것 (1 <= r <= n)

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        totalCnt = 0;

        input = new int[n];
        numbers = new int[r];

        for (int i = 0; i < n; i++) {
            input[i] = sc.nextInt();
        }
        comb(0, 0);
        System.out.println("총 경우의 수: " + totalCnt);

    }

    //cnt: 직전까지 뽑은 조합에 포함된수의 개수
    //start: 시도할 수의 시작 위치
    private static void comb(int cnt, int start) {
        if(cnt == r){
            totalCnt ++;
            System.out.println(Arrays.toString(numbers));
            return;
        }
        // 가능한 모든 수에 대해 시도(input 배열의 가능한 수 시도)
        // start부터 처리 시 중복 수 추출 방지 및 순서가 다른 조합 추출 방지지        for (int i = start; i < n; i++) {
        for (int i = start; i < n; i++) {
            // start 위치부터 처리했으므로 중복 체크 필요없음!
            // 앞쪽에서 선택되지 않았다면 수를 사용
            numbers[cnt] = input[i];
            // 다음 수 추출 시작
            comb(cnt + 1, i + 1);
        }

    }

    }

