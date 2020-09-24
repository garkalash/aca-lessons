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
        BinaryTreeNode node = nodeContaining(data);

        if(node == null){
            return;
        } else if(node.getLeft() != null && node.getRight() != null){
            BinaryTreeNode predecessor = predecessor(node);
            node.setData(predecessor.getData());
            node = predecessor;
        }

        Node pullUp = leftOf((Node) node) == null ? rightOf((Node) node) : leftOf((Node) node);
        if(pullUp != null){
            if(node == root){
                setRoot(pullUp);
            } else if(node.getParent().getLeft() == node){
                node.getParent().setLeft(pullUp);
            } else {
                node.getParent().setRight(pullUp);
            }
            if(isBlack((Node) node)){
                adjustAfterRemoval((Node) node);
            }
        } else if(node == root){
           setRoot(null);
        } else {
            if(isBlack((Node) node)){
                adjustAfterRemoval((Node) node);
            }
            node.removeFromParent();
        }

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
        while(n != root && isBlack(n)){
            if(n == leftOf(parentOf(n))){
                Node sibling = rightOf(parentOf(n));
                if(isRed(sibling)){
                    setColor(sibling, Color.BLACK);
                    setColor(parentOf(n), Color.RED);
                    rotateLeft(parentOf(n));
                    sibling = rightOf(parentOf(n));
                }

                if(isBlack(leftOf(sibling)) && isBlack(rightOf(sibling))){
                    setColor(sibling, Color.RED);
                    n = parentOf(n);
                } else {
                    if(isBlack(rightOf(sibling))){
                        setColor(leftOf(sibling), Color.BLACK);
                        setColor(sibling, Color.RED);
                        rotateRight(sibling);
                        sibling = rightOf(parentOf(n));
                    }
                    setColor(sibling, colorOf(parentOf(n)));
                    setColor(parentOf(n), Color.BLACK);
                    setColor(rightOf(n), Color.BLACK);
                    rotateLeft(parentOf(n));
                    n = (Node) root;
                }
            } else {
                Node sibling = leftOf(parentOf(n));
                if(isRed(sibling)){
                    setColor(sibling, Color.BLACK);
                    setColor(parentOf(n), Color.RED);
                    rotateRight(parentOf(n));
                    sibling = leftOf(parentOf(n));
                }

                if(isBlack(leftOf(sibling)) && isBlack(rightOf(sibling))){
                    setColor(sibling, Color.RED);
                    n = parentOf(n);
                } else {
                    if(isBlack(leftOf(sibling))){
                        setColor(rightOf(sibling), Color.BLACK);
                        setColor(sibling, Color.RED);
                        rotateLeft(sibling);
                        sibling = leftOf(parentOf(n));
                    }
                    setColor(sibling, colorOf(parentOf(n)));
                    setColor(parentOf(n), Color.BLACK);
                    setColor(leftOf(n), Color.BLACK);
                    rotateRight(parentOf(n));
                    n = (Node) root;
                }
            }

            setColor(n, Color.BLACK);
        }



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
