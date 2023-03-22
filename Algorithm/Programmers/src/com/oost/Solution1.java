package com.oost;

public class Solution1 {
    public static void main(String[] args) {

    }

    public int solution(String s){
        int[] alphabet = new int[26];

        char[] charList = s.toCharArray();
        for (char c : charList) {
            alphabet[c - 97]++;
        }

        int result = 0;


        for (int i : alphabet) {
            if(i%2 != 0) result++;
        }
        return result;
    }
}
/*
id
name
description
isEnalbed
created
createby
updated
updatedby

 */