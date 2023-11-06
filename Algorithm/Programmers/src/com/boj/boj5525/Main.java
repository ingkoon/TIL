package com.boj.boj5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * boj 5525 IOI
 */
public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        m = Integer.parseInt(bf.readLine());

        char[] ioi = bf.readLine().toCharArray();

        int cnt = 0;
        int result = 0;

        for (int i = 1; i < m - 1; i++) {
           if(ioi[i-1] == 'I' && ioi[i] == 'O' && ioi[i+1] == 'I'){
               cnt++;
               if(cnt == n){
                   cnt--;
                   result++;
               }
               i++;
           }
           else{
               cnt = 0;
           }
        }
        System.out.println(result);
    }
}
