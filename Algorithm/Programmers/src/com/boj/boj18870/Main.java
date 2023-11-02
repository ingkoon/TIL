package com.boj.boj18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] coordinates;
    static Map<Integer, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());

        coordinates = new int[n];
        map = new HashMap<>();

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            coordinates[i] = num;
        }

        int[] sortedCoordinates = coordinates.clone();

        Arrays.sort(sortedCoordinates);

        int idx = 0;
        for (int i = 0; i < n; i++) {
            int num = sortedCoordinates[i];
            if(!map.containsKey(num)){
                map.put(num, idx);
                idx++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int num = coordinates[i];
            int coordinate = map.get(num);
            sb.append(coordinate).append(" ");
        }

        System.out.println(sb);
    }
}
