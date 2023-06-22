package com.oost.p2;
// you can also use imports, for example:

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S) {

        char[] arr = S.toCharArray();
        int idx = arr.length-1;
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i]-'a' <= arr[i+1] - 'a') continue;
            idx = i;
            break;
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < arr.length; i++){
            if(i == idx) continue;
            sb.append(arr[i]);
        }
        // Implement your solution here
        return sb.toString();
    }
}
