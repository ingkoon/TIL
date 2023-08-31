package com.level3;
import java.util.*;
public class Solution_기지국_설치 {
    public static void main(String[] args) {
        int n = 11;
        int[] stations = {4, 11};
        int w = 1;
        System.out.println(solution(n, stations, w));
    }
    static int solution(int n, int[] stations, int w) {
        int answer = 0;
        Arrays.sort(stations);
        int stationIdx = 0;
        int apartIdx = 1;

        while(apartIdx <= n){
            if(stationIdx < stations.length && apartIdx >= stations[stationIdx] - w){
                apartIdx = stations[stationIdx] + w  + 1;
                stationIdx++;
            }else{
                answer++;
                apartIdx += 2 * w + 1;
            }
        }
        return answer;
    }
}
