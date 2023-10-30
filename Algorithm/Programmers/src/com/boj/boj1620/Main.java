package com.boj.boj1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        Map<Integer, String> numberMap = new HashMap<>();
        Map<String, Integer> stringMap = new HashMap<>();

        for(int i = 1; i <= n; i++) {
            String pokemon = bf.readLine();
            numberMap.put(i, pokemon);
            stringMap.put(pokemon, i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < m; i++) {
            String tmp = bf.readLine();
            if(tmp.charAt(0) <= '9'){
                sb.append(numberMap.get(Integer.parseInt(tmp))).append("\n");
                continue;
            }
            sb.append(stringMap.get(tmp)).append("\n");
        }
        System.out.println(sb);
    }
}
