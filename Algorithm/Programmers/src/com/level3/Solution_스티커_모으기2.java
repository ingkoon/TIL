package com.level3;

public class Solution_스티커_모으기2 {
    public static void main(String[] args) {
        int[] input = {14, 6, 5, 11, 3, 9, 2, 10};
        System.out.println(solution(input));
    }
    static int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];

        int answer = 0;
        int[][] dp = new int[2][sticker.length];

        dp[0][0] = sticker[0];
        dp[0][1] = sticker[0];
        dp[1][1] = sticker[1];
        for(int i = 2; i < sticker.length; i++){
            dp[0][i] = Math.max(sticker[i] + dp[0][i-2], dp[0][i-1]);
            dp[1][i] = Math.max(sticker[i] + dp[1][i-2], dp[1][i-1]);
        }

        answer = Math.max(dp[0][sticker.length-2], dp[1][sticker.length-1]);
        return answer;
    }
}

/*
크게 두 가지의 조건으로 분류된다.
가장 먼저, 첫 번째에서 시작하는가의 여부
두 번째로는 해당 idx의 번호를 뽑는가 아닌가에 대한 여부
따라서 2*sticker.length만큼의 dp배열을 선언 후
for문을 순회하면서 길이를 파악한다.
*/
