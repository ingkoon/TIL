package com.boj.boj27172;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, SIZE = 1000_001;
    static int[] numbers;
    static User[] users;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        numbers = new int[SIZE];
        Arrays.fill(numbers, -1);
        n = Integer.parseInt(bf.readLine());
        users = new User[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(st.nextToken());
            numbers[tmp] = i; // 해당 카드를 갖고 있는 유저의 번호를 추가한다.
            users[i] = new User(tmp, 0); // user객체 배열에 할당
        }

        for (int i = 0; i < n; i++) { // user를 순회
            int number = users[i].number;
            for (int j = number * 2; j < SIZE; j += number) { // 모든 카드 번호를 순회
                if(numbers[j] == -1) // 없는 카드 번호라면 넘긴다.
                    continue;
                users[i].score++; // score 추가
                users[numbers[j]].score--; // 졌으므로 score 감소
            }
        }

        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.score).append(" ");
        }
        System.out.println(sb);
    }

    static class User{
        int number;
        int score;

        public User(int number, int score) {
            this.number = number;
            this.score = score;
        }
    }
}
