package com.level3;

import java.util.Arrays;

public class Solution_섬_연결하기 {
    static int[] parents;
    static int SIZE;

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, costs));
    }
    static int solution(int n, int[][] costs) {
        parents = new int[n];
        SIZE = costs.length;
        int answer = 0;
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2])); // 간선의 비용에 따라 정렬 수행
        for(int i = 0; i < n; i++){ // 부모 배열 초기화
            parents[i] = i;
        }
        for(int i = 0; i < SIZE; i++){
            if(find(costs[i][0]) != find(costs[i][1])){ // 간선이 연결되어 있지 않은 경우
                union(costs[i][0], costs[i][1]); // 연결 수행
                answer+= costs[i][2]; // 최종 값에 간선의 비용 추가
            }
        }
        return answer;
    }

    static void union(int x, int y){ // union 연산, 두 값의 루트 노드를 연결한다.
        int rootX = find(x);
        int rootY = find(y);
        if(rootX > rootY){
            parents[rootX] = rootY;
        }else{
            parents[rootY] = rootX;
        }
    }

    static int find(int x){ // 루트노드를 탐색하는 함수
        if(parents[x] ==x)
            return x;
        return find(parents[x]);
    }
}
