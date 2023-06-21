package com.level2;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class PG_64065_튜플v2 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String input2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(Arrays.toString(Arrays.stream(solution(input2)).toArray()));
    }

    static int[] solution(String s){
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String n = matcher.group();
            System.out.println(n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
}
