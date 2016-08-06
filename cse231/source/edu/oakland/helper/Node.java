package edu.oakland.helper;

/**
 * This class represents a node that contains a key and its data
 * for a binary tree.
 *
 * @author Serar Matloob, Michael Frieze, Tiantian Ma, Jesse Emelian
 * @version 1.0 - Date: 160407
 * @since 1.0
 */
public class Node {

    private int key;
    private int data;
    private Node leftChild;
    private Node rightChild;

    /**
     * Constructor assigns parameters to instance variables that
     * represent a key and the data that this node can contain.
     *
     * @param key  value of a node
     * @param data value of a node
     */
    public Node(int key, int data) {
        this.key = key;
        this.data = data;
    }

    /**
     * Gets the key value of selected node
     *
     * @return key value of the selected node
     */
    public int getKey() {
        return key;
    }

    /**
     * Gets the data value of the selected node
     *
     * @return key value of selected node
     */
    public int getData() {
        return data;
    }

    /**
     * Gets left child of selected node
     *
     * @return the left child of a selected node
     */
    public Node getLeftChild() {
        return leftChild;
    }

    /**
     * Gets right child of selected node
     *
     * @return the right child of a selected node
     */
    public Node getRightChild() {
        return rightChild;
    }

    /**
     * Sets node as the right child of a parent node
     *
     * @param rightNode right node of a parent node
     */
    public void setRightChild(Node rightNode) {
        this.rightChild = rightNode;
    }

    /**
     * Sets node as the left child of a parent node
     *
     * @param leftNode left node of a parent node
     */
    public void setLeftChild(Node leftNode) {
        this.leftChild = leftNode;
    }

    /**
     * Convert key and data value to a string object
     *
     * @return key and data values of selected node as a string
     */
    @Override
    public String toString() {
        return data + " has the key " + key;
    }
}
