package com.aca.algorithms.trees;

/**
 * @author: garik
 * @created" 9/12/2020, 11:11 AM
 */


class BinaryTree{
    Node root;

    void postOrder(Node node){
        if(node == null){
            return;
        }

        postOrder(node.left);
        postOrder(node.right);

        System.out.print(node.key + ", ");
    }

    void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.key + ", ");
        preOrder(node.left);
        preOrder(node.right);

    }

    void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.key + ", ");
        inOrder(node.right);

    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(5);
        binaryTree.root.left = new Node(3);
        binaryTree.root.right = new Node(10);

        binaryTree.root.left.left = new Node(1);

        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(12);
        binaryTree.root.right.right.right = new Node(13);
        binaryTree.root.right.right.right.right = new Node(14);

        binaryTree.inOrder(binaryTree.root);

        System.out.println(">>>>");
        binaryTree.postOrder(binaryTree.root);

        System.out.println(">>>>");
        binaryTree.preOrder(binaryTree.root);

    }
}
