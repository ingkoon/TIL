package com.boj.boj13413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * BOJ 13413 오셀로 재배치
 */
public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(bf.readLine());
            char[] userInputs = bf.readLine().toCharArray();
            char[] targetInputs = bf.readLine().toCharArray();

            int white = 0;
            int black = 0;

            for (int i = 0; i < n; i++) {
                char userInput = userInputs[i];
                char targetInput = targetInputs[i];

                if(userInput != targetInput){
                    if(userInput == 'W')
                        white++;
                    else
                        black++;
                }
            }
            int max = Math.max(white, black);
            int min = Math.min(white, black);

            if(min == 0)
                System.out.println(max);
            else{
                int result = max - min + min;
                System.out.println(result);
            }
        }
    }
}
