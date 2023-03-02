package com.ssafy.classtest;

public class Marin {
    int hp = 100;
    void run (){
        hp -= 10;
        System.out.println("RUN " + hp);
    }

    public Marin(int hp) {
        this.hp = hp;
    }

    public Marin() {
    }
}
