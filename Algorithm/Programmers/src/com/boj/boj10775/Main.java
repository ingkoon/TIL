package com.boj.boj10775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//boj 10775 g2 공항
public class Main {
    static int G, P, result;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(bf.readLine());

        parent = new int[G+1];
        for (int i = 1; i <= G; i++) {
            parent[i] = i;
        }
        P = Integer.parseInt(bf.readLine());
        for (int i = 0; i < P; i++) {
            int plane = Integer.parseInt(bf.readLine());
            int isDocking = find(plane);
            if(isDocking == 0){ // 더이상 갱신 할 수 없는 상태일 경우 중단
                break;
            }
            result++;
            union(isDocking, isDocking-1); // 해당 게이트의 차선책을 하나 감소시킨다.
        }

        System.out.println(result);
    }

    static int find(int x){ // union-find의 find
        if(x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y){ // union 함수 : parent의 변경을 수행한다.
        x = find(x); // 변경 요소의 최상단 부모 정보를 가져온다.
        y = find(y); // 변경 정보를 가져온다.
        if(x != y){ // 두개의 값이 일치하지 않을 경우: 일치할 경우 두 값의 최상단 부모 정보는 같다.
            parent[x] = y; // 정보 수정
        }
    }
}
