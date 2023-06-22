package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1107_리모컨 {
    static int n, m;
    static boolean[] buttons;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        buttons = new boolean[10];
        if(m != 0){
            String[] numbers = bf.readLine().trim().split(" ");
            for (String number : numbers) {
                int tmp = Integer.parseInt(number);
                buttons[tmp] = true;
            }
        }

        int result = Math.abs(n - 100);

        for(int i = 0; i < 1000000; i++){
            String num = String.valueOf(i);
            boolean isCheck = false;
            for (int j = 0; j < num.length(); j++) {
                int button = num.charAt(j) - '0';
                if(buttons[button]){
                    isCheck = true;
                    break;
                }
            }
            if(isCheck) continue;
            int tmp = Math.abs(n-i) + num.length();
            result = Math.min(result, tmp);
        }
        System.out.println(result);
    }
}
