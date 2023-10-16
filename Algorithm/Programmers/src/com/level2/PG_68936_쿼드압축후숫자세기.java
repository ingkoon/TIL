package com.level2;
import java.util.*;


public class PG_68936_쿼드압축후숫자세기 {
    public static void main(String[] args) {
        int[][] arr = 	{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[] result = solution(arr);
        System.out.println(Arrays.toString(result));
    }

    static int[] solution(int[][] arr) {
        int size = arr.length;
        int[] answer = new int[2];
        Queue<Board> queue= new LinkedList<>();
        queue.offer(new Board(0,0,size));


        while(!queue.isEmpty()){
            Board board = queue.poll();
            int pr = board.r;
            int pc = board.c;
            int psize = board.size;
            if(isCheck(arr, board)){
                answer[arr[pr][pc]]++;
            }else{
                int nsize = psize/2;
                if(nsize == 1){
                    for(int i = pr; i < pr + psize; i++){
                        for(int j = pc; j < pc + psize; j++){
                            answer[arr[i][j]]++;
                        }
                    }
                    continue;
                }
                queue.offer(new Board(pr, pc, nsize));
                queue.offer(new Board(pr + nsize, pc, nsize));
                queue.offer(new Board(pr, pc + nsize, nsize));
                queue.offer(new Board(pr + nsize, pc + nsize, nsize));
            }
        }

        return answer;
    }

    static boolean isCheck(int[][] arr, Board board){
        int num = arr[board.r][board.c];
        for(int i = board.r; i< board.r + board.size; i++){
            for(int j = board.c; j < board.c + board.size; j++){
                if(arr[i][j] != num)
                    return false;
            }
        }
        return true;
    }

    static class Board{
        int r;
        int c;
        int size;
        public Board(int r, int c, int size){
            this.r = r;
            this.c = c;
            this.size = size;
        }

        @Override
        public String toString(){
            return this.r + " " + this.c + " " + this.size;
        }
    }
}
