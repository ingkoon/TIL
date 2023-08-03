package com.boj.boj2138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 전구와 스위치
public class Main {
    static int n;
    static String current;
    static char[] currentArray;

    static String target;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        current = bf.readLine();
        currentArray = current.toCharArray();
        target = bf.readLine();
    }

    static void turn(int idx){
        if(idx == 0){
            currentArray[idx] = turnLight(currentArray[idx]);
            currentArray[idx+1] = turnLight(currentArray[idx+1]);
        }
        else if(idx == n - 1){
            currentArray[idx] = turnLight(currentArray[idx]);
            currentArray[idx-1] = turnLight(currentArray[idx-1]);
        }
        else{
            currentArray[idx] = turnLight(currentArray[idx]);
            currentArray[idx+1] = turnLight(currentArray[idx+1]);
            currentArray[idx-1] = turnLight(currentArray[idx-1]);
        }
    }

    static char turnLight(char light){
        light = light == '0' ? '1' : '0';
        return light;
    }
}
/*
N개의 스위치와 N개의 전구가 있다.
각각의 전구는 켜져 있는 상태와 꺼져 있는 상태 중 하나의 상태를 가진다.
i(1 < i < N)번 스위치를 누르면 i-1, i, i+1의 세 개의 전구의 상태가 바뀐다.
즉, 꺼져 있는 전구는 켜지고, 켜져 있는 전구는 꺼지게 된다.
1번 스위치를 눌렀을 경우에는 1, 2번 전구의 상태가 바뀌고, N번 스위치를 눌렀을 경우에는 N-1, N번 전구의 상태가 바뀐다.

N개의 전구들의 현재 상태와 우리가 만들고자 하는 상태가 주어졌을 때,
그 상태를 만들기 위해 스위치를 최소 몇 번 누르면 되는지 알아내는 프로그램을 작성하시오.
 */