package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_12904_A와B {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer s = new StringBuffer(bf.readLine());
        StringBuffer t = new StringBuffer(bf.readLine());

        while (s.length() < t.length()){
            if(t.charAt(t.length()-1) == 'A') t.deleteCharAt(t.length()-1);
            else {
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
        }

        if(s.toString().equals(t.toString())) System.out.println(1);
        else System.out.println(0);
    }


}
