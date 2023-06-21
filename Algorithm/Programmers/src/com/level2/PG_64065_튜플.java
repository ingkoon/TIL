package com.level2;
import java.util.*;

public class PG_64065_튜플 {
    public static void main(String[] args) {
        String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String input2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        System.out.println(solution(input2));
    }

    static int[] solution(String s){
        String[] tmp = s.replace("{","").split("},");
        tmp[tmp.length-1] = tmp[tmp.length-1].replace("}","");

        int[] answer = new int[tmp.length];
        List<Integer> result = new ArrayList<>();
        Arrays.sort(tmp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] arr1 = o1.split(",");
                String[] arr2 = o2.split(",");
                return arr1.length - arr2.length;
            }
        });

        for(String str : tmp) {
            String[] stringArr = str.split(",");
            int[] numbers = Arrays.stream(stringArr)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            System.out.println(Arrays.toString(numbers));

            for (int number : numbers) {
                if(!result.contains(number))
                    result.add(number);
            }

            for (int i = 0; i < result.size(); i++) {
                answer[i] = result.get(i);
            }
        }

        return answer;
    }
}
