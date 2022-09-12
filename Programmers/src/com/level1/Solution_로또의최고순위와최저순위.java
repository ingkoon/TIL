package com.level1;

import java.util.Arrays;


public class Solution_로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        Solution_로또의최고순위와최저순위 s = new Solution_로또의최고순위와최저순위();
        System.out.println(Arrays.toString(s.solution(lottos, win_nums)));

    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] result = new int[2];

        int cnt = 0;
        int getCnt = 0;

        for (int lotto : lottos) {
            if(Arrays.stream(win_nums)
                    .filter(x -> x == lotto)
                    .count() > 0
            ) getCnt++;
            else if(lotto == 0) cnt ++;

        }
        result[0] = Math.min(7- (getCnt + cnt), 6);
        result[1] = Math.min(7 - (getCnt), 6);

        return result;
    }
}
