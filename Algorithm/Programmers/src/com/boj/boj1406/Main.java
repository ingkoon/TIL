package com.boj.boj1406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * BOJ 1406 S2 에디터
 */
public class Main {
    static int n;

    static Stack<Character> mainStack;
    static Stack<Character> subStack;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        mainStack = new Stack<>();
        subStack = new Stack<>();

        char[] word = bf.readLine().toCharArray();
        for (char alphabet : word) {
            mainStack.push(alphabet);
        }

        n = Integer.parseInt(bf.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            String tmp = st.nextToken();
            switch (tmp){
                case "L":
                    L();
                    break;
                case "D":
                    D();
                    break;
                case "B":
                    B();
                    break;
                case "P":
                    char alphabet = st.nextToken().charAt(0);
                    P(alphabet);
                    break;
                default:
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!subStack.isEmpty())
            mainStack.push(subStack.pop());
        while (!mainStack.isEmpty())
            sb.append(mainStack.pop());
         sb.reverse();

        System.out.println(sb);

    }

    static void L(){
        if(mainStack.isEmpty())
            return;
        subStack.push(mainStack.pop());
    }

    static void D(){
        if(subStack.isEmpty())
            return;
        mainStack.push(subStack.pop());
    }

    static void B(){
        if(mainStack.isEmpty())
            return;
        mainStack.pop();
    }

    static void P(char alphabet){
        mainStack.push(alphabet);
    }
}
