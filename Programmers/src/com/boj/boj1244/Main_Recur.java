package com.boj.boj1244;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main_Recur {
    static int n;
    static int[] switchs;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("src/com/boj/boj1244/case.txt"));

        n = sc.nextInt();
        switchs = new int[n];
        for (int i = 0; i < n; i++) switchs[i] = sc.nextInt();

        int m = sc.nextInt();
        int sex = 0;
        int num = 0;

        for (int i = 0; i < m; i++) {
            sex = sc.nextInt();
            num = sc.nextInt();
            if (sex == 1) male(num-1, num);
            else femaleV2(num-1, 0);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(switchs[i] + " ");
            if((i+1) % 20 == 0)
                System.out.println();
        }
    }

    // 재귀 형식
    private static void femaleV2(int num, int cnt){
        switchs[num + cnt] = switchs[num - cnt] = switchs[num+cnt] == 0 ? 1 : 0;
        cnt += 1;

        if(num + cnt < n && num - cnt >=0 && switchs[num + cnt] == switchs[num - cnt])
            femaleV2(num, cnt);
    }

    private static void male(int num, int cnt) {
        System.out.println(num + " " + cnt);
        switchs[num] =  switchs[num] == 0 ? 1 : 0;
        num += cnt;
        if(num < n) male( num, cnt);
    }
}
