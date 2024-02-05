package com.boj.boj1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 1339 G5 단어수학
 */
public class Main {
    static int n;
    static Alphabet[] alphabets;
    static String[] words;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        alphabets = new Alphabet[26];
        words = new String[n];

        for (int i = 0; i < 26; i++) {
            alphabets[i] = new Alphabet((char)('A'+i));
        }

        for (int i = 0; i < n; i++)
            words[i] = bf.readLine();

        for (int i = 0; i < n; i++) {
            char[] cur = words[i].toCharArray();
            for (int j = 0; j < cur.length; j++) {
                int alphabet = cur[j];
                if(alphabets[alphabet - 'A'].w == -1)
                    alphabets[alphabet-'A'].w =0;
                alphabets[alphabet-'A'].w += Math.pow(10, cur.length - j);
            }
        }

        Map<Character, Integer> map = new HashMap<>();
        Arrays.sort(alphabets, (o1, o2) -> o2.w - o1.w);

        for (int i = 0; i < 10; i++)
            map.put(alphabets[i].a, 9 - i);

        int result = 0;
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char[] tmp = words[i].toCharArray();
            for (char c : tmp) {
                int num = map.get(c);
                sb.append(num);
            }
            result+= Integer.parseInt(sb.toString());
        }
        System.out.println(result);
    }

    static class Alphabet{
        char a;
        int w = -1;
        public Alphabet(char a) {
            this.a = a;
        }
    }
}
