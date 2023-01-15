package com.boj.boj1244;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main_Repeat {
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
            if (sex == 1) male(num);
//            else female(num);
            else female(num);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(switchs[i] + " ");
            if((i+1) % 20 == 0)
                System.out.println();
        }
    }

    private static void female(int num) {
        num -= 1;
        for (int i = 0; i < n; i++) {
            if(num-i < 0 || num+i >= n) break;
            if (switchs[num + i] == switchs[num-i]) {
                switchs[num - i] = switchs[num + i] = switchs[num+i] == 0 ? 1 : 0;
            }
            else
                break;
        }
    }


    private static void male(int num) {
            for (int i = num-1; i < n; i+=num) {
                switchs[i] = switchs[i] == 0? 1 : 0;
            }
    }
}
