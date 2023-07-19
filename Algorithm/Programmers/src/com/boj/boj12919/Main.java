package com.boj.boj12919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// A와 B 2
public class Main {
    static String S, T;
    static int SIZE, result;
    static Queue<Word> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        S = bf.readLine();
        T = bf.readLine();

        SIZE = T.length();

        queue = new LinkedList<>();
        queue.offer(new Word(T.length(), T));
        while (!queue.isEmpty()){
            Word currentWord = queue.poll(); // 현재 단어 pop;

            if(currentWord.word.equals(S)){
                result = 1;
                break;
            }
            if(currentWord.size == 0){
                continue;
            }
            if(currentWord.word.charAt(currentWord.size-1) == 'A'){
                queue.offer(new Word(currentWord.size-1, deleteA(currentWord.word)));
            }
            if(currentWord.word.charAt(0) == 'B'){
                queue.offer(new Word(currentWord.size-1, deleteB(currentWord.word)));
            }
        }
        System.out.println(result);
    }

    static String deleteA(String word){
        return word.substring(0, word.length()-1);
    }
    static String deleteB(String word){
        String tmp = word.substring(1, word.length());
        StringBuilder sb = new StringBuilder(tmp);
        return sb.reverse().toString();
    }

    static class Word{
        int size;
        String word;
        public Word(int size, String word) {
            this.size = size;
            this.word = word;
        }
    }
}