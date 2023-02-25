package com.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_22232_가희와파일탐색기 {
    static int n, m;
    static String[] arr;
    static Map<String, Integer> extension;

    public static void main(String[] args)throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new String[n];
        for (int i = 0; i < n; i++) {
            String tmp = bf.readLine();
            arr[i] = tmp;
        }

        extension = new HashMap<>();
        for (int i = 0; i < m; i++) {
            String tmp = bf.readLine();
            extension.put(tmp, i);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] split1 = o1.split("\\.");
                String[] split2 = o2.split("\\.");

                Integer a1 = split1[0].hashCode();
                Integer b1 = split2[0].hashCode();

                Integer a2 = split1[1].hashCode();
                Integer b2 = split2[1].hashCode();

                if(split1[0].hashCode() != split2[0].hashCode()){
                    return a1.compareTo(b1);
                }
                if(extension.containsKey(split1[1]) && !extension.containsKey(split2[1]))
                    return -1;
                if(!extension.containsKey(split1[1]) && extension.containsKey(split2[1]))
                    return 1;
                if(extension.containsKey(split1[1]) && extension.containsKey(split2[1])){
                    return extension.get(split1[1]) - extension.get(split2[1]);
                }


                return a2.compareTo(b2);
            }
        });

        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println("1".hashCode());

    }
}
/*
5 3
a1bc.jpeg
aabc.jpg
foo.yolo
bar.cpp
bar.maltise
jpg
cpp
maltise
 */