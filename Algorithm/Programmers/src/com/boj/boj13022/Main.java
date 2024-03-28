package com.boj.boj13022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static String input;
    static final String REGEX = "(w+o+l+f+)+";
    static Map<Character, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        input = bf.readLine();
        map = new HashMap<>();
        char[] charArr = input.toCharArray();


        boolean result = true;
        for (int i = 0; i < charArr.length; i++) {
            char tmp = charArr[i];
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            if(i < charArr.length-1 && tmp == 'f' && charArr[i+1] == 'w' && !isCheck()){
                result = false;
                break;
            }
        }
        result = result && input.matches(REGEX) && isCheck();

        System.out.println(result ? 1 : 0);
    }

    static boolean isCheck(){

        int w = map.getOrDefault('w', 0);
        int o = map.getOrDefault('o', 0);
        int l = map.getOrDefault('l', 0);
        int f = map.getOrDefault('f', 0);

        return w == o && o == l && l == f && f == w;
    }
}
