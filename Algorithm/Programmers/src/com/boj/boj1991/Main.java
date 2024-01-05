package com.boj.boj1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int n;
    static Node root;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(bf.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            char[] tmp = bf.readLine().toCharArray();
            char data = tmp[0];
            char left = tmp[2];
            char right = tmp[4];
            createNode(data, left, right);
        }

        preOrder(root);
        sb.append("\n");
        inOrder(root);
        sb.append("\n");
        postOrder(root);
        System.out.println(sb);
    }
    static void createNode(char data, char left, char right){
        if(root == null){
            root = new Node(data);
            root.left = setNode(left);
            root.right = setNode(right);
        }
        else
            searchNode(root, data, left, right);
    }

    static void searchNode(Node node, char data, char left, char right){
        if(node == null)
            return;
        if (node.data == data){
            node.left = setNode(left);
            node.right = setNode(right);
        } else {
            searchNode(node.left, data, left, right);
            searchNode(node.right, data, left, right);
        }
    }

    static void preOrder(Node node){
        if(node != null) {
            sb.append(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    static void inOrder(Node node){
        if(node != null){
            if(node.left != null)
                inOrder(node.left);
            sb.append(node.data);
            if(node.right != null)
                inOrder(node.right);
        }
    }

    static void postOrder(Node node){
        if(node!=null){
            if(node.left != null)
                postOrder(node.left);
            if(node.right != null)
                postOrder(node.right);
            sb.append(node.data);
        }
    }

    static Node setNode(char data){
        return data != '.' ? new Node(data) : null;
    }

    static class Node{
        char data;
        Node left;
        Node right;

        public Node(char data) {
            this.data = data;
        }
    }
}
