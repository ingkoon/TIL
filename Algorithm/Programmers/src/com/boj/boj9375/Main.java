package com.boj.boj9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());

        for (int t = 0; t < T; t++) {
            int clothes = Integer.parseInt(bf.readLine());
            Map<String, Integer> map = new HashMap<>();

            for (int i = 0; i < clothes; i++) {
                String[] tmp = bf.readLine().split(" ");
                int cnt = map.getOrDefault(tmp[1], 0);
                map.put(tmp[1], cnt+1);
            }
            int result = 1;
            for (String category : map.keySet())
                result *= (map.get(category) + 1);
            result-=1;
            System.out.println(result);
        }
    }
}
