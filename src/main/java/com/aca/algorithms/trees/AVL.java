package com.aca.algorithms.trees;

/**
 * @author: garik
 * @created: 9/12/2020, 11:10 AM
 */
public class AVL {
    Node root;

    int max(int a, int b){
        return a>b ? a : b;
    }

    int balFact(Node node){
        if(node == null) return 0;
        return node.balanceFactor;
    }

    Node rightRotate(Node y){
        Node x  = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.balanceFactor = max(balFact(y.left), balFact(y.right)) + 1;
        x.balanceFactor = max(balFact(x.left), balFact(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x){
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        y.balanceFactor = max(balFact(y.left), balFact(y.right)) + 1;
        x.balanceFactor = max(balFact(x.left), balFact(x.right)) + 1;

        return y;
    }

    int height(Node node){
        if(node == null) return 0;
        return max(height(node.left), height(node.right)) + 1;
    }

    Node insert(Node node, int key){
       if(node == null){
           return new Node(key);
       }
       if(key < node.key){
           node = insert(node.left, key);
       } else if(key > node.key){
           node = insert(node.right, key);
       } else {
           return node;
       }

       node.balanceFactor = height(node.right)  - height(node.left);
       //right right
       if(node.balanceFactor == 2 && key < node.left.key){
           return rightRotate(node);
       }

       //left left
       if(node.balanceFactor == -2 && key > node.right.key){
           return leftRotate(node);
       }

       if(node.balanceFactor == -2 && key < node.right.key){
           node.right = rightRotate(node.right);
           return leftRotate(node);

       }

       if(node.balanceFactor == 2 && key > node.left.key){
           node.left = leftRotate(node.left);
           return rightRotate(node);

       }

       return node;
    }
}
