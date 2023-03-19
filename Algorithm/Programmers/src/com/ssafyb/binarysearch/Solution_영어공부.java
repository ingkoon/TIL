package com.ssafyb.binarysearch;

import java.util.Scanner;
import java.lang.Math;

public class Solution_영어공부 {
    static int n, p;
    static int[] a;
    
    public static int solve(){
        int ans = 0;
        for (int i=0;i<n;i++){
            int L=i, R=n - 1, mid;
            while (L <= R){
                mid = (L+R) / 2;
                int blank = (a[mid] - a[i] + 1) - (mid - i + 1);
                if (blank > p) {
                    R = mid - 1;
                } else {
                    L = mid + 1;
                    ans = Math.max(ans, a[mid] + (p - blank) - a[i] + 1);
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int maximum_date = 1000001;
        int T = sc.nextInt();   //테스트케이스
        for(int test_case = 1; test_case <= T; test_case++){
            n = sc.nextInt();   //공부를 한 날
            p = sc.nextInt();   //해킹을 할 수 있는 기회
            a = new int[n];
            for(int i =0; i<n; i++){
                a[i] = sc.nextInt();
            }
            int ans = solve();
            System.out.println("#" + test_case + " " + ans);
        }
    }
}