package com.boj.boj18868;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * BOJ 18868 멀티버스 1
 */
public class Main {
    static int n, m;
    static int[][] cosmos;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        cosmos = new int[m][n];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < n; j++) {
                cosmos[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }

        int result = 0;
        for (int i = 0; i < m-1; i++) {
            for (int j = i+1; j < m; j++) {
                if(isPair(i, j))
                    result++;
            }
        }

        System.out.println(result);
    }

    static boolean isPair(int base, int target){
        int[] baseCosmos = cosmos[base];
        int[] targetCosmos = cosmos[target];

        for (int i = 0; i < n-1; i++) {

            int baseFirst =  baseCosmos[i];
            int targetFirst = targetCosmos[i];

            for (int j = i+1; j < n; j++) {
                int baseSecond = baseCosmos[j];
                int targetSecond = targetCosmos[j];
                if(!isSameResult(baseFirst, targetFirst, baseSecond, targetSecond))
                    return false;
            }
        }
        return true;
    }

    static boolean isSameResult(int baseFirst, int targetFirst, int baseSecond, int targetSecond){
        int firstResult = baseFirst - baseSecond;
        int secondResult = targetFirst - targetSecond;

        int first = firstResult > 0 ? 1 : firstResult == 0 ? 0 : -1;
        int second = secondResult > 0 ? 1 : secondResult == 0 ? 0 : -1;

        return first == second;
    }
}
