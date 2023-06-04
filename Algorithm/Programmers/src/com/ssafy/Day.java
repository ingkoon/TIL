package com.ssafy;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Day {
    public static void main(String[] args) {
        String names = "|윤혜진|\n" +
                "|민동주|\n" +
                "|손유진|\n" +
                "|이리나|\n" +
                "|이현정|\n" +
                "|함정빈|\n" +
                "|이수련|\n" +
                "|권용재|\n" +
                "|민초현|\n" +
                "|임성민|\n" +
                "|장엄지|\n" +
                "|한기현|\n" +
                "|김민경|\n" +
                "|김재희|\n" +
                "|박진우|\n" +
                "|이유경|\n" +
                "|정다은|\n" +
                "|노정환|\n" +
                "|박주희|\n" +
                "|조현민|\n" +
                "|최종현|\n" +
                "|한원종|\n" +
                "|한선희|\n" +
                "|강윤주|\n" +
                "|배서연|\n" +
                "|정채린|\n" +
                "|최유태|\n" +
                "|전인덕|\n" +
                "|김도원|\n" +
                "|김범식|\n" +
                "|오현규|\n" +
                "|윤재휘|\n" +
                "|김설희|\n" +
                "|김원규|\n" +
                "|박미희|\n" +
                "|이성훈|\n" +
                "|이한빈|\n" +
                "|정훈|\n" +
                "|공예찬|\n" +
                "|권태윤|\n" +
                "|장예주|\n" +
                "|정세권|\n" +
                "|주대선|\n" +
                "|서철원|\n" +
                "|소지현|\n" +
                "|이인재|\n" +
                "|장지웅|";

        StringTokenizer st = new StringTokenizer(names);
        ArrayList<String> list = new ArrayList<>();
        while(st.hasMoreTokens()){
            String s = st.nextToken();
            list.add(s);
        }
        int size = list.size();

        int winner1 = (int)(Math.random() * size);
        int winner2 = (int)(Math.random() * size);
        System.out.println(list.get(winner1) + " " + list.get(winner2));
    }
}
