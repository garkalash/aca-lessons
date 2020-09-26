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

    int countNodes(Node root){
        if(root == null) return 0;
        return 1 + countNodes(root.right) + countNodes(root.left);
    }

    boolean isComplete(Node root, int index, int counts){
        if(root == null ) return true;
        if(index >= counts) return false;
        return isComplete(root.left, 2 * index +1, counts) && isComplete(root.right, 2 * index + 2, counts);
    }

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();

        binaryTree.root = new Node(5);
        binaryTree.root.left = new Node(3);
        binaryTree.root.right = new Node(10);

        binaryTree.root.left.left = new Node(1);
        binaryTree.root.left.right = new Node(1);

        binaryTree.root.right.right = new Node(6);

        System.out.println(binaryTree.isComplete(binaryTree.root, 0, binaryTree.countNodes(binaryTree.root)));


    }
}
