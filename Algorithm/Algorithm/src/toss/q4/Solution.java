//package toss.q4;
//
//
//import java.util.HashMap;
//
//class com.sweab.힙.com.sweab.배낭문제.com.sweab.최장공통부분수열.Solution {
//    static boolean[] visited;
//    static int[] root;
//    static HashMap<String, Integer> user = new HashMap<>();
//
//    public long[] solution(long[][] invitationPairs) {
//        visited = new boolean[invitationPairs.length];
//        root = new int[Integer.MAX_VALUE];
//
//        for (int i = 0; i < invitationPairs.length; i++) {
//            dfs(invitationPairs[i][1], invitationPairs[i][0], 10);
//            visited = new boolean[invitationPairs.length];
//        }
//        long[] answer = {};
//        return answer;
//    }
//
//    static void dfs(long v, long start, int depth){
//        visited[(int) v] = true;
//        for (int i = 0; i < ; i++) {
//
//        }
//    }
//}