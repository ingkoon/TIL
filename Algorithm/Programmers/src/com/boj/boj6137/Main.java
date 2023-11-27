package com.boj.boj6137;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static String result;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++)
            sb.append(bf.readLine());

        result = sb.toString();
        char[] array = sb.toString().toCharArray();

        setString(new StringBuilder(),0, n-1, array);
        System.out.println(result);
    }

    static void setString(StringBuilder tmp, int left, int right, char[] array){
        if(left > right){
            result = tmp.toString();
            return;
        }
//        System.out.println(tmp);
        if(tmp.length()!= 0 && tmp.length() % 80 == 0)
            tmp.append("\n");

        if(array[left] < array[right])
            setString(tmp.append(array[left]), left + 1, right, array);
        else if(array[left] > array[right])
            setString(tmp.append(array[right]), left, right-1, array);
        else {
            int tmpLeft = left;
            int tmpRight = right;
            while (tmpLeft < tmpRight){
                tmpLeft++;
                tmpRight--;
                if(array[tmpLeft] < array[tmpRight]){
                    setString(tmp.append(array[left]), left + 1, right, array);
                    break;
                }
                else if(array[tmpLeft] > array[tmpRight]) {
                    setString(tmp.append(array[right]), left, right - 1, array);
                    break;
                }
            }
            if(tmpLeft > tmpRight)
                setString(tmp.append(array[left]), left + 1, right, array);
        }
    }
}
/*
7
A
C
D
F
D
C
B
 */