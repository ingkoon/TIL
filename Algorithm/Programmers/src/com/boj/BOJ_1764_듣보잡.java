package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeMap;

public class BOJ_1764_듣보잡 {
    static int n, m, result;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = bf.readLine().split(" ");

        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        TreeMap<String, Integer> map = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        for (int i = 0; i < n; i++)
            map.put(bf.readLine(), 1);
        for (int i = 0; i < m; i++){
            String tmp = bf.readLine();
            if(map.get(tmp) == null){
                continue;
            }
            result++;
            map.put(tmp, 2);
        }
        System.out.println(result);
        for (String key : map.keySet()) {
            if(map.get(key) == 2) System.out.println(key);
        }
    }
}
/*
3 4
ohhenrie
charlie
baesangwook
obama
ohhenrie
clinton
baesangwook
 */