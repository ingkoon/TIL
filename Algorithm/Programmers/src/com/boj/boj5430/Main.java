package com.boj.boj5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            char[] calc = bf.readLine().toCharArray();
            int n = Integer.parseInt(bf.readLine());
            String inputString = bf.readLine();
            inputString = inputString.substring(1, inputString.length()-1);
            Deque<Integer> deque;
            if(inputString.length() == 0){
                deque = new ArrayDeque<>();
            }else{
                deque = Arrays.stream(Arrays.stream(inputString.split(","))
                                .mapToInt(Integer::parseInt)
                                .toArray())
                        .boxed()
                        .collect(Collectors.toCollection(ArrayDeque::new));
            }

            sb.append(calcArray(deque, calc, n)).append("\n");
        }
        System.out.println(sb);
    }

    static String calcArray(Deque<Integer> deque, char[] calc, int n){
        boolean isReverse = false;
        try{
            for (char c : calc) {
                if(c == 'R'){
                    isReverse = !isReverse;
                }else{
                    if(isReverse){
                        deque.removeLast();
                    }else{
                        deque.removeFirst();
                    }
                }
            }
        } catch (Exception e){
            return "error";
        }

        int size = deque.size();
        if(size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        if(isReverse){
            for (int i = 0; i < size - 1; i++) {
                sb.append(deque.removeLast()).append(",");
            }
        }else{
            for (int i = 0; i < size - 1; i++) {
                sb.append(deque.pop()).append(",");
            }
        }
        sb.append(deque.pop());
        sb.append("]");
        return sb.toString();
    }
}
