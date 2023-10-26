package com.boj.boj10866;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static String[] commands = {"push_front", "push_back", "pop_front", "pop_back", "size", "empty", "front", "back"};
    static Deque<Integer> deque;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String command = bf.readLine();
            parsingKeyword(command);
        }
    }

    static void parsingKeyword(String keyword){
        StringTokenizer st = new StringTokenizer(keyword);
        String command = st.nextToken();
        for(int i = 0; i < commands.length; i++) {
            if(!commands[i].equals(command))
                continue;
            if(i == 0 || i == 1){
                int num = Integer.parseInt(st.nextToken());
                pushDeque(i, num);
            }
            else if(i == 2 || i == 3){
                System.out.println(popDeque(i));
            }
            else if(i == 4){
                System.out.println(deque.size());
            }
            else if(i == 5){
                System.out.println(deque.isEmpty() ? 1 : 0);
            }
            else{
                System.out.println(getDeque(i));
            }
            break;
        }
    }

    static void pushDeque(int i, int num){
        if(i == 0){
            deque.addFirst(num);
            return;
        }
        deque.addLast(num);
    }

    static int popDeque(int i){
        if(deque.isEmpty())
            return -1;
        if(i == 2)
            return deque.removeFirst();
        return deque.removeLast();
    }

    static int getDeque(int i){
        if(deque.isEmpty())
            return -1;
        if(i == 6)
            return deque.getFirst();
        return deque.getLast();
    }
}
