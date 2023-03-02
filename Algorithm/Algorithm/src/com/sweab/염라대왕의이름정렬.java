package com.sweab;

import java.util.Scanner;

public class 염라대왕의이름정렬 {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
int T = sc.nextInt();
for (int testCase = 1; testCase <= T; testCase++) {
int len = sc.nextInt();
String[] words = new String[len];
for (int i=0; i<len; i++) {
words[i] = sc.next();
}
mergeSort(words);
System.out.printf("#%d\n", testCase);
String prev = "";
for(String word: words) {
if (!word.equals(prev)) {
System.out.println(word);
}
prev = word;
}
}
}

static void mergeSort(String[] arr) {
if (arr.length == 1) {
return;
}
int center = arr.length / 2;
String[] head = arrCopy(arr, 0, center);
String[] tail = arrCopy(arr, center, arr.length);
mergeSort(head);
mergeSort(tail);

int headPtr = 0;
int tailPtr = 0;
int index = 0;
while (index < arr.length) {
if (headPtr == head.length) {
arr[index] = tail[tailPtr];
tailPtr++;
}
else if (tailPtr == tail.length) {
arr[index] = head[headPtr];
headPtr++;
}
else {
if (compare(head[headPtr], tail[tailPtr])) {
arr[index] = tail[tailPtr];
tailPtr++;
}
else {
arr[index] = head[headPtr];
headPtr++;
}
}
index++;
}
return;
}

static String[] arrCopy(String[] arr, int start, int end) {
String[] result = new String[end - start];
for (int i=start; i<end; i++) {
result[i-start] = arr[i];
}
return result;
}

static boolean compare(String s1, String s2) {
if (s1.length() != s2.length()) {
return s1.length() > s2.length();
}
for (int i=0; i<Math.max(s1.length(), s2.length()); i++) {
char c1 = getChar(s1, i);
char c2 = getChar(s2, i);
if (c1 != c2) {
return c1 > c2;
}
}
return true;
}

static char getChar(String s, int index) {
if (index >= s.length()) {
return 0;
}
return s.charAt(index);
}
}