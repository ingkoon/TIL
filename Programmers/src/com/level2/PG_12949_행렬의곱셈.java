package com.level2;

import java.util.Arrays;

public class PG_12949_행렬의곱셈 {
    public static void main(String[] args) {
        int[][] arr1 = new int[][] {{1,4}, {3,2}, {4,1}};
        int[][] arr2 = new int[][] {{3,3}, {3,3}};

        int[][] result = solution2(arr1, arr2);

        for (int[] ints : result) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];

        for(int i = 0 ; i < arr1.length ; ++i){
            for(int j = 0 ; j < arr2[0].length ; ++j){
                for(int k = 0 ; k < arr1[0].length ; ++k) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }

    static int[][] solution2(int[][] arr1, int[][] arr2) {
        int[][] result = new int[arr1.length][arr2[0].length];

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2[0].length; j++) {
                for (int k = 0; k < arr1[0].length; k++) {
                    result[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return result;
    }


}
