package com.aca.algorithms.trees;

import java.awt.*;
import java.util.Comparator;

/**
 * A simple red-black tree class.
 */
public class RedBlackTree extends BinarySearchTree {


    public RedBlackTree() {
        this(null);
    }

    public RedBlackTree(Comparator c) {
        super(c);
    }

    class Node extends LinkedBinaryTreeNode {
        Color color = Color.black;
        public Node(Object data) {
            super(data);
        }
    }


    public void add(Object data) {
        if(root == null){
            root = new Node(data);
        }

        BinaryTreeNode n = root;
        while (true){
            int compResult = compare(n.getData(), data);
            if(compResult == 0){
                n.setData(data);
                break;
            } else if(compResult < 0){
                if(n.getRight() == null){
                    Node node = new Node(data);
                    n.setRight(node);
                    adjustAfterInsertion((Node) n.getRight());
                    break;
                }
                n = n.getRight();
            } else {
                if(n.getLeft() == null){
                    Node node = new Node(data);
                    n.setLeft(node);
                    adjustAfterInsertion((Node) n.getLeft());
                    break;
                }
                n = n.getLeft();
            }
        }
    }

    public void remove(Object data) {
        //implementation here
    }

    private void adjustAfterInsertion(Node n) {
        n.color = Color.RED;

        if(n != root && isRed(parentOf(n))){
            if(isRed(siblingOf(parentOf(n)))){
                setColor(parentOf(n), Color.BLACK);
                setColor(siblingOf(parentOf(n)), Color.BLACK);
                setColor(grandparentOf(n), Color.RED);
                adjustAfterInsertion(grandparentOf(n));
            } else if(parentOf(n) == leftOf(grandparentOf(n))){
                if(n == rightOf(parentOf(n))){
                    rotateLeft(n = parentOf(n));
                }
                setColor(parentOf(n), Color.BLACK);
                setColor(grandparentOf(n), Color.RED);
                rotateRight(grandparentOf(n));

            } else if(parentOf(n) == rightOf(grandparentOf(n))){
                if(n == leftOf(parentOf(n))){
                    rotateRight(n = parentOf(n));
                }
                setColor(parentOf(n), Color.BLACK);
                setColor(grandparentOf(n), Color.RED);
                rotateLeft(grandparentOf(n));

            }

            setColor((Node) root, Color.BLACK);

        }
    }

    private void adjustAfterRemoval(Node n) {
        //implementation
    }

    // The following helpers dramatically simplify the code by getting
    // all the null pointer checking out of the adjustment methods.

    private Color colorOf(Node n) {
        return n == null ? Color.black : n.color;
    }

    private boolean isRed(Node n) {
        return n != null && colorOf(n) == Color.red;
    }

    private boolean isBlack(Node n) {
        return n == null || colorOf(n) == Color.black;
    }

    private void setColor(Node n, Color c) {
        if (n != null)
            n.color = c;
    }

    private Node parentOf(Node n) {
        return n == null ? null : (Node) n.getParent();
    }

    private Node grandparentOf(Node n) {
        return (n == null || n.getParent() == null) ? null : (Node) n.getParent().getParent();
    }

    private Node siblingOf(Node n) {
        return (n == null || n.getParent() == null) ? null
                : (n == n.getParent().getLeft()) ? (Node) n.getParent().getRight() : (Node) n.getParent().getLeft();
    }

    private Node leftOf(Node n) {
        return n == null ? null : (Node) n.getLeft();
    }

    private Node rightOf(Node n) {
        return n == null ? null : (Node) n.getRight();
    }
}
