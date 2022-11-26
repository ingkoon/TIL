package com.devmatching;

import java.util.StringTokenizer;

public class Solution1 {
    public static void main(String[] args) {
        int low = 25;
        int high = 51;
        String[] img = {".########......",
                ".####...#......",
                ".#.####.#.#####",
                ".#.#..#.#.#..##",
                ".#.##.#.#.#...#",
                ".#.####.#.#...#",
                ".#....###.#####",
                ".########......"};

        System.out.println(solution(low, high, img));

    }
    static String[][] arr;
    static int SIZE;
    static int solution(int low , int high, String[] img){
        int answer = 0;
        SIZE = img.length;
        arr = new String[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            arr[i] = img[i].split("");
        }


        for(int i = 0; i < SIZE/2; i++){
            int n = SIZE - i;
            if(check(n)){
                answer= checkCount(n);

                break;
            };
        }
        return answer;
    }

    static boolean check(int n){
        boolean flag = true;
        int s = SIZE-n;
        for (int i = s; i < n; i++) {
            if(arr[s][i].equals(".") || arr[i][n].equals(".") || arr[i][s].equals(".") || arr[n][i].equals(",")) flag = false;
        }
        return flag;
    }

    static int checkCount(int n){
        int s = SIZE- n;
        int count = 0;
        for (int i = s; i < n; i++) {
            for (int j = s; j < n; j++) {
                if(arr[i][j].equals("#")) count++;
            }
        }
        return count;
    }

}
