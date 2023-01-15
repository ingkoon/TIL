package toss.q2;

public class Solution {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] b= {1,2,3,4};
        System.out.println(solution(a));
    }

    static int solution(int[] levels) {
        int answer = 0;
        double size = levels.length;
        double a = size * 0.25;
        for (int i = levels.length-1; i > levels.length - (int)size+1; i--) {
            answer  = levels[i];
        }
        return answer;
    }
}