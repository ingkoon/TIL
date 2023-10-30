package com.boj.boj17219;

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

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        StringBuilder sb =  new StringBuilder();

        for (int i = 0; i < m; i++) {
            sb.append(map.get(bf.readLine())).append("\n");
        }
        bf.close();

        System.out.println(sb);
    }
}
