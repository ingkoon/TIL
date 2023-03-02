package com.level1;
import java.util.*;

public class Solution_신고결과받기 {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {

        int[] answer = new int[id_list.length];

        //신고 카운트, 신고한 사람을 저장하기 위한 map
        Map<String, ArrayList<String>> log = new HashMap();
        Map<String, Integer> cnt = new HashMap();

        System.out.println(Arrays.toString(id_list));

        for(int i = 0; i< id_list.length; i++){
            log.put(id_list[i], new ArrayList<>());
            cnt.put(id_list[i], 0);
        }

        //for문을 통해 값 부여
        // for(String n : id_list){
        //     log.put(n, new HashSet<>());
        //     cnt.put(n, 0);
        // }

        System.out.println(log);

        // 중복 제거
        String[] setReport = Arrays
                .stream(report)
                .distinct()
                .toArray(String[]::new);



        for(int i =0; i< setReport.length; i++){
            String[] reportArr = setReport[i].split(" ");

            log.get(reportArr[0]).add(reportArr[1]);
            cnt.put(reportArr[1], cnt.get(reportArr[1])+1);
        }

        int idx = 0;

        for(String user : log.keySet()){
            for(String c : cnt.keySet()){
                if(cnt.get(c) >= k && log.get(user).contains(c))
                    answer[idx] ++;
            }
            idx ++;
        }



        return answer;
    }
}

