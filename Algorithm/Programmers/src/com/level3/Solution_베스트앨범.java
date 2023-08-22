package com.level3;
import java.util.*;


public class Solution_베스트앨범 {
        static Map<String, List<Music>> map;
        static int SIZE;

        public static void main(String[] args) {
          String[] inputGenre = {"classic", "pop", "classic", "classic", "pop"};
          int[] inputPlays = {500, 600, 150, 800, 2500};
          System.out.println(Arrays.toString(solution(inputGenre, inputPlays)));
        }
        static int[] solution(String[] genres, int[] plays) {
            map = new HashMap<>(); // 장르/식별&재생횟수가 들어가는 hashmap 인스턴스 생성
            SIZE = genres.length; // 배열 크기만큼 SIZE 지정

            for(int i = 0; i < SIZE; i++){ //배열을 순회하며 장르 map에 music 인스턴스 추가
                String genre = genres[i];
                int play = plays[i];

                List<Music> musics = map.getOrDefault(genre, new ArrayList<Music>()); // 해당 key의 값이 비어있다면 new List 추가
                musics.add(new Music(i, play)); // 리스트에 인스턴스 추가
                map.put(genre, musics);
            }

            ArrayList<Map.Entry<String, List<Music>>> entries = new ArrayList<>(map.entrySet()); // map을 entry로 변경
            entries.sort((v1, v2) ->  getSum(v2.getValue()) - getSum(v1.getValue())); // comparator를 통해 내림차순 정렬 수행

            int size = 0;
            for(Map.Entry<String, List<Music>> entry : entries){
                size += entry.getValue().size() > 1 ? 2 : 1;
            } // 배열 크기의 정수 선언
            int[] answer = new int[size];
            int cnt = 0;

            for (Map.Entry<String, List<Music>> entry : entries) {
                entry.getValue().sort(new Comparator<Music>() {
                    @Override
                    public int compare(Music o1, Music o2) {
                        if(o1.play == o2.play){
                            return o1.id - o2.id;
                        }
                        return o2.play - o1.play;
                    }
                });
                // Comparator를 통해 재생횟수가 같을 경우 식별자가 낮은 music이 우선순위를 갖고 재생횟수가 많은 쪽이 먼저 재생되도록 구성

                for(int i = 0; i < (entry.getValue().size() > 1 ? 2 : 1); i++){
                    answer[cnt++] = entry.getValue().get(i).id; // 1보다 크다면 2만큼, 작다면 1만큼 결과 배열에 추가되도록 구성
                }
            }

            return answer;
        }

        /* 음악데이터 리스트를 parameter로 갖는 함수
        comparator를 통해 장르별 총 재생횟수를 비교하기 위해 작성
         */
        static int getSum(List<Music> data){
            int sum = 0;
            for (Music datum : data) {
                sum += datum.play;
            }
            return sum;
        }

        static class Music{ // 식별값을 갖는 정수와 재생횟수가 들어가는 클래스 생성
            int id;
            int play;
            public Music(int id, int play){
                this.id = id;
                this.play = play;
            }
        }

}
