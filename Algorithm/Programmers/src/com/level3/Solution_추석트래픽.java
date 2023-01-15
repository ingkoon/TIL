package com.level3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Solution_추석트래픽 {
    public static void main(String[] args) throws Exception {
        String[] lines= {"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };

        Solution_추석트래픽 s = new Solution_추석트래픽();
        System.out.println(s.solution(lines));
    }

    public int solution(String[] lines) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        int[] cnt = new int[lines.length];
        int answer = 0;

        for (int i = 0; i < lines.length; i++) {
            String[] line = lines[i].split(" ");
            Date date = format.parse(line[1]);
            long time = date.getTime();

            for (int j = i; j < lines.length; j++) {
                String[] nLine = lines[j].split(" ");
                Date nDate = format.parse(nLine[1]);
                double sec = Double.parseDouble(nLine[2].substring(0, nLine[2].length()-1));

                long over = (long)(nDate.getTime() - sec * 1000 + 1);
                if(time + 1000> over){
                    cnt[i]++;
                    answer = Math.max(answer , cnt[i]);
                }
            }
        }
        return answer;
    }
}
