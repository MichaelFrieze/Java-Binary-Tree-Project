package edu.oakland.production;

import edu.oakland.helper.*;

import java.util.*;

/**
 * This class is responsible for build binary tree and search desired numbers
 * by using different methods. It will be tested by Junit test class and finally
 * merged with other JCF classes. To properly use this class, you must call
 * buildBinaryTree() before you can use methods such as searchOddPreOrder() or
 * use any of the get methods.
 *
 * @author Serar Matloob, Michael Frieze, Tiantian Ma, Jesse Emelian
 * @version 1.0 - Date 160407
 * @since 1.0
 */
public class BinaryTree {

    private Node root;
    private int[] keyArray, dataArray;
    private int[] oddNumberArray;
    private int oddNumberToReturn = 2;
    private int oddNumber;
    private int startRange = 900;
    private int endRange = 9000;
    private long startTime, endTime;
    private ArrayList<Integer> arrayList;

    /**
     * Constructor for Binary tree class.
     * Also conduct the arrayList and oddNumberArray for further using.
     *
     * @param keyArray  key value array
     * @param dataArray data value array
     */
    public BinaryTree(int[] keyArray, int[] dataArray) {
        this.keyArray = keyArray;
        this.dataArray = dataArray;
        oddNumberArray = new int[oddNumberToReturn];
        Arrays.fill(oddNumberArray, -1);
        arrayList = new ArrayList<>();
    }

    /**
     * This buildBinaryTree method build the binary tree by adding Nodes in it.
     */
    public void buildBinaryTree() {
        for (int i = 0; i < keyArray.length; i++) {
            addNode(keyArray[i], dataArray[i]);
        }
    }

    /**
     * This method implement the business rules for the Binary Tree
     * structure.
     *
     * @param key  key value of a node
     * @param data data value of a node
     */
    public void addNode(int key, int data) {
        Node newNode = new Node(key, data);
        if (root == null) {
            root = newNode;
        } else {
            Node focusNode = root;
            Node parent;
            while (true) {
                parent = focusNode;
                if (key < focusNode.getKey()) {
                    focusNode = focusNode.getLeftChild();
                    if (focusNode == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }

                } else {
                    focusNode = focusNode.getRightChild();
                    if (focusNode == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }

        }
    }

    /**
     * This method conducts the seaching by using preorder traverse tree and
     * records the processing time.
     */
    public void searchOddPreOrder() {
        startTime = System.nanoTime();
        preOrderTraverseTree(root);
        endTime = System.nanoTime();
    }

    /**
     * This method conducts the seaching by using inorder traverse tree and
     * records the processing time.
     */
    public void searchOddInOrder() {
        startTime = System.nanoTime();
        inOrderTraverseTree(root);
        endTime = System.nanoTime();
    }

    /**
     * This method conducts the seaching by using postorder traverse tree and
     * records the processing time.
     */
    public void searchOddPostOrder() {
        startTime = System.nanoTime();
        postOrderTraverseTree(root);
        endTime = System.nanoTime();
    }

    /**
     * This method conducts the preorder traverse of the Binary Tree and meanwhile
     * searchs for the desired odd numbers.The found numbers are placed into an
     * arraylist.
     *
     * @param focusNode root Node
     */
    public void preOrderTraverseTree(Node focusNode) {

        if (focusNode != null && arrayList.size() < oddNumberToReturn) {

            if (focusNode.getData() % 2 != 0) {

                oddNumber = focusNode.getData();

                if (oddNumber >= startRange && oddNumber <= endRange) {

                    arrayList.add(oddNumber);
                }
            }
            preOrderTraverseTree(focusNode.getLeftChild());

            preOrderTraverseTree(focusNode.getRightChild());
        }
    }

    /**
     * This method conducts the inorder traverse of the Binary Tree and meanwhile
     * searchs for the desired odd numbers.The found numbers are placed into an
     * arraylist.
     *
     * @param focusNode root Node
     */
    public void inOrderTraverseTree(Node focusNode) {

        if (focusNode != null && arrayList.size() < oddNumberToReturn) {


            inOrderTraverseTree(focusNode.getLeftChild());

            if (focusNode.getData() % 2 != 0 && arrayList.size() < oddNumberToReturn) {

                oddNumber = focusNode.getData();

                if (oddNumber >= startRange && oddNumber <= endRange) {

                    arrayList.add(oddNumber);
                }
            }

            inOrderTraverseTree(focusNode.getRightChild());
        }
    }

    /**
     * This method conducts the postorder traverse of the Binary Tree and meanwhile
     * searchs for the desired odd numbers.The found numbers are placed into an
     * arraylist.
     *
     * @param focusNode root Node
     */
    public void postOrderTraverseTree(Node focusNode) {

        if (focusNode != null && arrayList.size() < oddNumberToReturn) {

            postOrderTraverseTree(focusNode.getLeftChild());

            postOrderTraverseTree(focusNode.getRightChild());

            if (focusNode.getData() % 2 != 0 && arrayList.size() < oddNumberToReturn) {

                oddNumber = focusNode.getData();

                if (oddNumber >= startRange && oddNumber <= endRange) {

                    arrayList.add(oddNumber);
                }
            }
        }
    }

    /**
     * Gets the desired odd numbers value from arrayList.
     *
     * @return int[] oddNumberArray;
     */
    public int[] getValues() {

        int index = 0;

        for (Integer number : arrayList) {

            oddNumberArray[index++] = number;
        }

        return oddNumberArray;

    }

    /**
     * Calculate the searching time.
     *
     * @return long endTime-startTime ;
     */
    public long getTime() {
        return (endTime - startTime);
    }

    /**
     * Get the root of the Node.
     *
     * @return Node root;
     */
    public Node getRoot() {
        return root;
    }

}