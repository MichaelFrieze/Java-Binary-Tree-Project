package edu.oakland.helper;

import java.util.*;

/**
 * This class is responsible for generating arrays of type int. The arrays
 * represent the values of the keys and data contained in the nodes of a
 * binary tree.
 *
 * @author Serar Matloob, Michael Frieze, Tiantian Ma, Jesse Emelian
 * @version 1.0 - Date: 160407
 * @since 1.0
 */
public class ArrayGen {

    /**
     * Instance variables and initial maximum and minimum values
     * of possible random numbers for each element in an array.
     */
    private int arraySize;
    private int maxValue = 20000; // default value
    private int minValue = 20; // default value
    private int[] keyArray;
    private int[] dataArray;
    private Random random;

    /**
     * Constructor assigns a parameter to an instance variable that represents the size
     * of the array to be generated and creates a Random() object that is assigned to
     * a reference that exist as an instance variable.
     *
     * @param arraySize A value of type int that represents the size of an array to build
     */
    public ArrayGen(int arraySize) {
        this.arraySize = arraySize;
        this.random = new Random();
    }

    /**
     * This method creates an int array that contains random values to be used as keys
     * for nodes in a binary tree. The conditions of this array must be that no
     * duplicates are created. The int array object is created, filled, and stored
     * in a reference that exist as an instance variable.
     * <p>
     * Also, the purpose of using LinkedhashSet to fill the int array, is
     * because of the usefullness of the .add() method. It prevents duplicates.
     */
    public void createNodeKeys() {
        Integer next;
        Set<Integer> generated = new LinkedHashSet<Integer>();
        this.keyArray = new int[arraySize];
        int index = 0;

        while (generated.size() < arraySize) {

            next = random.nextInt(arraySize);
            generated.add(next);
        }
        for (Integer key : generated) {

            keyArray[index++] = key;
        }
    }

    /**
     * This method creates an int array that contains random values to be used as the
     * data for nodes in a binary tree. The int array object is created, filled, and
     * stored in a reference that exist as an instance variable.
     * <p>
     * The range of possible values in each element of
     * the int array are determined by the instance variables maxValue and minValue.
     */
    public void createRandomDataArray() {

        this.dataArray = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {

            this.dataArray[i] = random.nextInt(maxValue) + minValue;
        }

    }

    /**
     * This method creates an int array that contains random EVEN values to be used as
     * the data for nodes in a binary tree. The int array object is created, filled, and
     * stored in a reference that exist as an instance variable.
     * <p>
     * The range of possible values in each element of
     * the int array are determined by the instance variables maxValue and minValue.
     */
    public void createEvenDataArray() {

        int[] evenArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int number = random.nextInt(maxValue) + minValue;
            if (number % 2 == 0) {
                evenArray[i] = number;
            } else {
                evenArray[i] = number + 1;
            }
        }
        dataArray = evenArray;
    }

    /**
     * This method creates an int array that contains random ODD values to be used as
     * the data for nodes in a binary tree. The int array object is created, filled, and
     * stored in a reference that exist as an instance variable.
     * <p>
     * The range of possible values in each element of
     * the int array are determined by the instance variables maxValue and minValue.
     */
    public void createOddDataArray() {

        int[] oddArray = new int[arraySize];
        for (int i = 0; i < arraySize; i++) {
            int number = random.nextInt(maxValue) + minValue;
            if (number % 2 != 0) {
                oddArray[i] = number;
            } else {
                oddArray[i] = number + 1;
            }
        }
        dataArray = oddArray;
    }

    /**
     * This method returns a referene to an array object of type int that
     * represents keys for a node in a binary tree.
     *
     * @return Returns the reference to an array object of type int containing node keys
     */
    public int[] getKeyArray() {

        return keyArray;
    }

    /**
     * This method returns a referene to an array object of type int that
     * represents data for a node in a binary tree.
     *
     * @return Returns the reference to an array object of type int containing data for nodes
     */
    public int[] getDataArray() {

        return dataArray;
    }

    /**
     * This method assigns the minimum int value of possible random numbers
     * to a reference that exist as an instance variable.
     *
     * @param minimum A value of type int that gets assigned to an instance variable
     */
    public void setMinValue(int minimum) {

        this.minValue = minimum;
    }

    /**
     * This method assigns the maximum int value of possible random numbers
     * to a reference that exist as an instance variable.
     *
     * @param maximum A value of type int that gets assigned to an instance variable
     */
    public void setMaxValue(int maximum) {

        this.maxValue = maximum;
    }
}