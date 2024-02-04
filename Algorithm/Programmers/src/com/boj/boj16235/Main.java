package com.boj.boj16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * BOJ 16235 G3 나무 재테크
 */
public class Main {
    static int n, m, k;
    static int[][] foods;
    static int[][] field;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static List<Tree> trees;


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        trees = new ArrayList<>();

        foods = new int[n+1][n+1];
        field = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                foods[i][j] = tmp;
                field[i][j] = 5;
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            trees.add(new Tree(x, y, age));
            Collections.sort(trees);
        }

        for (int i = 0; i < k; i++) {
            isSpring();
            isSummer();
            isFall();
            isWinter();
        }

        int result = trees.size();
        System.out.println(result);
    }

    static void isSpring(){
        int size = trees.size();
        for (int i = 0; i < size; i++) {
            Tree cur = trees.get(i);
            int x = cur.x;
            int y = cur.y;
            if(field[x][y] < cur.age){
                trees.get(i).isDead = true;
                continue;
            }
            field[x][y] -= cur.age;
            trees.get(i).age++;
        }
    }

    static void isSummer(){
        for (Tree tree : trees) {
            if (tree.isDead) {
                int x = tree.x;
                int y = tree.y;
                field[x][y] += tree.age / 2;
            }
        }

        trees.removeIf(tree -> tree.isDead);
    }

    static void isFall(){
        int size = trees.size();
        for (int i = 0; i < size; i++) {
            if(trees.get(i).age % 5 != 0)
                continue;
            Tree cur = trees.get(i);
            int x = cur.x;
            int y = cur.y;
            for (int j = 0; j < 8; j++) {
                int nx = x + dr[j];
                int ny = y + dc[j];
                if(!isCheck(nx, ny))
                    continue;
                trees.add(new Tree(nx, ny, 1));
            }
        }
        Collections.sort(trees);
    }

    static void isWinter(){
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                field[i][j] += foods[i][j];
            }
        }
    }

    static boolean isCheck(int nx, int ny){ // 번식 시 밖으로 벗어나지 않도록 하기 위한
        return 1 <= nx && nx <= n && 1 <= ny && ny <= n;
    }

    static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;
        boolean isDead = false;

        public Tree(int x, int y, int age) {
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }

        @Override
        public String toString() {
            return x + " " + y + " " + age + " / ";
        }
    }
}
