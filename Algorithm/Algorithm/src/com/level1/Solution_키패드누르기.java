package com.level1;

public class Solution_키패드누르기 {
    static int left;
    static int right;

    static StringBuilder sb;

    public static void main(String[] args) {

//        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
//        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        System.out.println(solution(numbers, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        left = 9;
        right = 11;
        sb = new StringBuilder();
        String answer = "";
        for(int n : numbers) {
            touch(n, hand);
        }
        return sb.toString();
    }
    public static void touch(int num, String hand){
        if(num == 0) num = 11;
        num --;
        int r = num%3; // 왼손일 경우 0,  중간일 경우 1, 오른손일 경우 2
        int c = num/3; // 첫 번째 라인일 경우 0, 두번째 라인일 경우 1, 세 번째 라인일 경우 2, 마지막 라인은 따로 처리

        if(r == 1){
            int lr = left%3;
            int lc = left/3;

            int rr = right%3;
            int rc = right/3;

            int leftVal = Math.abs(r - lr) + Math.abs(c - lc);
            int rightVal = Math.abs(r - rr) + Math.abs(c - rc);
            if(leftVal == rightVal && hand.equals("right")) {
                right = num;
                sb.append("R");
            }
            else if (leftVal == rightVal && hand.equals("left")){
                left = num;
                sb.append("L");
            } else{
                if(leftVal < rightVal){
                    left = num;
                    sb.append("L");
                }
                else{
                    right  = num;
                    sb.append("R");
                }
            }
            return;
        }

        if(r == 0){
            left = num;
            sb.append("L");
        }
        else{
            right = num;
            sb.append("R");
        }

    }
}
