package com.boj.boj5052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    static int T, n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(bf.readLine());
            Map<String, Boolean> map = new HashMap<>();

            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = bf.readLine();
            }

            Arrays.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.length() - o2.length();
                }
            });

            boolean answer = true;
            for (int i = 0; i < n; i++) {
                char[] tmp = arr[i].toCharArray();
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < tmp.length; j++) {
                    sb.append(tmp[j]);
                    boolean isCheck = map.getOrDefault(sb.toString(), false);
                    if(!isCheck){
                        if(j == tmp.length-1)
                            map.put(sb.toString(), true);
                        else
                            map.put(sb.toString(), false);
                    }
                    else{
                        answer = false;
                        break;
                    }
                }

                if(!answer)
                    break;
            }

            result.append(answer ? "YES" : "NO").append("\n");
        }

        System.out.println(result);
    }
}

/**
 *
 * map 타입의 변수를 만든다 <String, Node>
 * 입력에 대해서 길이순으로 정렬한다.
 * map을 순회하면서 isEnd가 true인 값이 나올 경우 일관성이 없는 것으로 간주
 */
