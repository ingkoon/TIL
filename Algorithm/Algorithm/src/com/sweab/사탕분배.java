package com.sweab;

import java.util.Scanner;

public class 사탕분배 {
public static void main(String[] args) throws Exception {
Scanner sc = new Scanner(System.in);
int T = sc.nextInt();
for (int testCase = 1; testCase <= T; testCase++) {
int num1 = sc.nextInt();
int num2 = sc.nextInt();
int cnt = sc.nextInt();
System.out.printf("#%d %d\n", testCase, solution(num1, num2, cnt));
}
}

static long solution(int num1, int num2, int cnt) {
int sum = num1 + num2;
int max = sum / 2;
long result = ((long)get2Power(cnt, sum) * (long)num1) % sum;
return result > max ? sum - result : result;
}

static int get2Power(int cnt, int mod) {
long res = 1;
long num = 2;
while (cnt > 0) {
if (cnt % 2 == 1) {
res = (res * num) % mod;
}
num = (num * num) % mod;
cnt /= 2;
}
return (int)res;
}
}